package io.einharjar.chasqui;

import io.einharjar.chasqui.converters.gsm.GSMConverter;
import io.einharjar.chasqui.converters.locale.Country;
import io.einharjar.chasqui.converters.locale.Language;
import io.einharjar.chasqui.converters.locale.Region;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

//TODO: Add french
public class GSMTest {

    private GSMConverter gsmConverter;

    @Before
    public void init(){
        this.gsmConverter = new GSMConverter();
    }

    @Test
    public void testDutch(){
        String dutchTestString    = "aëïüb";
        String expectedTestString = "aeiüb";
        assertEquals(gsmConverter.convert(dutchTestString, Language.Dutch), expectedTestString);

        String dutchSentence = "Eén week later stÿnd Van der Biest de voltalligë pers te ĳeý";
        String expectedDutchSentence = "Eén week later stynd Van der Biest de voltallige pers te ijey";
        assertEquals(gsmConverter.convert(dutchSentence, Language.Dutch), expectedDutchSentence);

        String dutchName = "Henriëtte";
        String expectedDutchName =  "Henriette";
        assertEquals(gsmConverter.convert(dutchName, Language.Dutch), expectedDutchName);
    }

    //Should work exactly the same as the dutch one.
    @Test
    public void testNetherlands(){
        String dutchTestString    = "aëïüb";
        String expectedTestString = "aeiüb";
        assertEquals(gsmConverter.convert(dutchTestString, Country.Netherlands), expectedTestString);

        String dutchSentence = "Eén week later stÿnd Van der Biest de voltalligë pers te ĳeý";
        String expectedDutchSentence = "Eén week later stynd Van der Biest de voltallige pers te ijey";
        assertEquals(gsmConverter.convert(dutchSentence, Country.Netherlands), expectedDutchSentence);

        String dutchName = "Henriëtte";
        String expectedDutchName =  "Henriette";
        assertEquals(gsmConverter.convert(dutchName, Country.Netherlands), expectedDutchName);
    }

    @Test
    public void testBenelux(){
        String beneTestString     = "HrjuêêèèÇΩÜÜ ôîïßßŷŷ";
        String expectedTestString = "HrjueeèèÇΩÜÜ oiißßyy";

        assertEquals(gsmConverter.convert(beneTestString, Region.Benelux), expectedTestString);
    }


    @Test
    public void testGerman(){
        String beneTestString     = "HrjuêêèèÇΩÜÜ ôîïßßŷŷ";
        String expectedTestString = "HrjueeèèÇΩÜÜ oiißßyy";

        assertEquals(gsmConverter.convert(beneTestString, Language.German), expectedTestString);
    }


    //master-mapping
    @Test
    public void testMaster(){
        String dutchTestString    = "aëïüb";
        String expectedTestString = "aeiüb";
        assertEquals(gsmConverter.convert(dutchTestString), expectedTestString);

        String dutchSentence = "Eén week later stÿnd Van der Biest de voltalligë pers te ĳeý";
        String expectedDutchSentence = "Eén week later stynd Van der Biest de voltallige pers te ijey";
        assertEquals(gsmConverter.convert(dutchSentence), expectedDutchSentence);

        String dutchName = "Henriëtte";
        String expectedDutchName =  "Henriette";
        assertEquals(gsmConverter.convert(dutchName), expectedDutchName);

        String combinedString     = "HrjuêêèèÇΩÜÜ ôîïßßŷŷEén week later stÿnd Van der Biest de voltalligë pers te ĳeý";
        String expectedCombinedString = "HrjueeèèÇΩÜÜ oiißßyyEén week later stynd Van der Biest de voltallige pers te ijey";

        assertEquals(gsmConverter.convert(combinedString), expectedCombinedString);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullArguments(){
        gsmConverter.convert("hello", (Country) null);
    }
    @Test()
    public void testSimpleStrings(){
        Assert.assertEquals(gsmConverter.convert("hello", Region.Benelux), "hello");
        Assert.assertEquals(gsmConverter.convert(" force  t h e reckoning", Region.Benelux), " force  t h e reckoning");
        Assert.assertEquals(gsmConverter.convert(" "), " ");
        Assert.assertEquals(gsmConverter.convert(" {{{8aeae "), " {{{8aeae ");
        Assert.assertEquals(gsmConverter.convert(null), null);
    }

}
