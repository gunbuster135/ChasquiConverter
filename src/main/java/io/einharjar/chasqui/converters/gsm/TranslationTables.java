package io.einharjar.chasqui.converters.gsm;

import io.einharjar.chasqui.converters.locale.Country;
import io.einharjar.chasqui.converters.locale.Language;
import io.einharjar.chasqui.converters.locale.Region;

import java.util.HashMap;
import java.util.Map;


public class TranslationTables {

    static Map<Language, Map<Character, String>> LANGUAGE_TABLE;
    static Map<Region, Map<Character, String>> REGION_TABLE;
    static Map<Country, Map<Character, String>> COUNTRY_TABLE;


    //Dutch
    private static Map<Character, String> DUTCH_TABLE;

    static {
        DUTCH_TABLE = new HashMap<Character, String>();

        //lower case
        DUTCH_TABLE.put('ë', "e");
        DUTCH_TABLE.put('ó', "o");
        DUTCH_TABLE.put('í', "i");
        DUTCH_TABLE.put('ï', "i");
        DUTCH_TABLE.put('ú', "u");
        DUTCH_TABLE.put('á', "a");
        DUTCH_TABLE.put('ý', "y");
        DUTCH_TABLE.put('ÿ', "y");
        DUTCH_TABLE.put('ĳ', "ij");

        //capital
        DUTCH_TABLE.put('Ë', "E");
        DUTCH_TABLE.put('Ó', "O");
        DUTCH_TABLE.put('Í', "I");
        DUTCH_TABLE.put('Ï', "I");
        DUTCH_TABLE.put('Ú', "U");
        DUTCH_TABLE.put('Á', "A");
        DUTCH_TABLE.put('Ý', "Y");
        DUTCH_TABLE.put('Ÿ', "Y");
        DUTCH_TABLE.put('Ĳ', "IJ");

        //Special letters
        DUTCH_TABLE.put('„', "\"");
    }

    //French
    private static Map<Character, String> FRENCH_TABLE;

    static {
        FRENCH_TABLE = new HashMap<Character, String>();
        //lower case
        FRENCH_TABLE.put('ï', "i");
        FRENCH_TABLE.put('ë', "e");
        FRENCH_TABLE.put('ê', "e");
        FRENCH_TABLE.put('î', "i");
        FRENCH_TABLE.put('û', "u");
        FRENCH_TABLE.put('ô', "o");

        //capital
        FRENCH_TABLE.put('Ï', "I");
        FRENCH_TABLE.put('Ë', "E");
        FRENCH_TABLE.put('Ê', "E");
        FRENCH_TABLE.put('Î', "I");
        FRENCH_TABLE.put('Û', "U");
        FRENCH_TABLE.put('Ô', "O");
    }


    //German
    private static Map<Character, String> GERMAN_TABLE;

    static {
        GERMAN_TABLE = new HashMap<Character, String>();

        //lower case
        GERMAN_TABLE.put('â', "a");
        GERMAN_TABLE.put('ó', "o");
        GERMAN_TABLE.put('ï', "i");
        GERMAN_TABLE.put('ë', "e");
        GERMAN_TABLE.put('ê', "e");
        GERMAN_TABLE.put('î', "i");
        GERMAN_TABLE.put('û', "u");
        GERMAN_TABLE.put('ô', "o");
        GERMAN_TABLE.put('ŷ', "y");
        GERMAN_TABLE.put('ÿ', "y");
        GERMAN_TABLE.put('ú', "u");

        //capital
        GERMAN_TABLE.put('Â', "A");
        GERMAN_TABLE.put('Ó', "O");
        GERMAN_TABLE.put('Ï', "I");
        GERMAN_TABLE.put('Ë', "E");
        GERMAN_TABLE.put('Ê', "E");
        GERMAN_TABLE.put('Î', "I");
        GERMAN_TABLE.put('Û', "U");
        GERMAN_TABLE.put('Ô', "O");
        GERMAN_TABLE.put('Ŷ', "Y");
        GERMAN_TABLE.put('Ÿ', "Y");
        GERMAN_TABLE.put('Ú', "U");
    }

    //Benelux
    private static Map<Character, String> BENE_TABLE;

    static {
        BENE_TABLE = new HashMap<Character, String>();
        BENE_TABLE.putAll(DUTCH_TABLE);
        BENE_TABLE.putAll(FRENCH_TABLE);
        BENE_TABLE.putAll(GERMAN_TABLE);
    }

    //Netherlands
    private static Map<Character, String> NETHERLANDS_TABLE;

    static {
        NETHERLANDS_TABLE = new HashMap<Character, String>();
        NETHERLANDS_TABLE.putAll(DUTCH_TABLE);
    }

    //Germany
    private static Map<Character, String> GERMANY_TABLE;

    static {
        GERMANY_TABLE = new HashMap<Character, String>();
        GERMANY_TABLE.putAll(GERMAN_TABLE);
    }


    //Master table, all tables from other languages merged into one. If collisions occur it doesnt really matter ( for now...)
    static Map<Character, String> MASTER_TABLE;

    static {
        MASTER_TABLE = new HashMap<Character, String>();
        MASTER_TABLE.putAll(DUTCH_TABLE);
        MASTER_TABLE.putAll(FRENCH_TABLE);
        MASTER_TABLE.putAll(GERMANY_TABLE);
    }

    static {
        LANGUAGE_TABLE = new HashMap<Language, Map<Character, String>>();
        LANGUAGE_TABLE.put(Language.Dutch, DUTCH_TABLE);
        LANGUAGE_TABLE.put(Language.German, GERMAN_TABLE);
    }

    static {
        REGION_TABLE = new HashMap<Region, Map<Character, String>>();
        REGION_TABLE.put(Region.Benelux, BENE_TABLE);
    }

    static {
        COUNTRY_TABLE = new HashMap<Country, Map<Character, String>>();
        COUNTRY_TABLE.put(Country.Netherlands, NETHERLANDS_TABLE);
        COUNTRY_TABLE.put(Country.Germany, GERMANY_TABLE);
    }
}
