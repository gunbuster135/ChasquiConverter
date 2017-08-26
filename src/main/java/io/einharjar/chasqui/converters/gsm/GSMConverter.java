package io.einharjar.chasqui.converters.gsm;

import io.einharjar.chasqui.converters.locale.Country;
import io.einharjar.chasqui.converters.locale.Language;
import io.einharjar.chasqui.converters.Converter;
import io.einharjar.chasqui.converters.locale.Region;
import io.einharjar.chasqui.converters.util.Helper;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

import static io.einharjar.chasqui.converters.util.Helper.*;

public class GSMConverter implements Converter {


    public GSMConverter(){

    }

    public String convert(String s, Language lang) {
        if(isBlank(s)){
            return s;
        }
        return convert(s, retrieveTranslationTable(lang));
    }

    public String convert(String s, Country country) {
        if(isBlank(s)){
            return s;
        }
        return convert(s, retrieveTranslationTable(country));
    }

    public String convert(String s, Region region) {
        if(isBlank(s)){
            return s;
        }
        return convert(s, retrieveTranslationTable(region));
    }

    public String convert(String s){
        if(isBlank(s)){
            return s;
        }
        return convert(s, TranslationTables.MASTER_TABLE);
    }

    public boolean validate(String s) {
        return false;
    }

    private String convert(String s, Map<Character, String> translationMap){
        StringBuilder translatedString = new StringBuilder();

        for(Character c : s.toCharArray()){
            String correspondingValue = translationMap.get(c);
            if(correspondingValue == null){
                translatedString.append(c);
            } else {
                translatedString.append(correspondingValue);
            }
        }
        return translatedString.toString();
    }

    private Map<Character,String> retrieveTranslationTable(Language lang){
        checkNull(lang, "Language cannot be null");
        Map<Character, String> translationMap = TranslationTables.LANGUAGE_TABLE.get(lang);
        return translationMap != null ? translationMap : TranslationTables.MASTER_TABLE;
    }

    private Map<Character,String> retrieveTranslationTable(Country country){
        checkNull(country, "Country cannot be null");
        Map<Character, String> translationMap = TranslationTables.COUNTRY_TABLE.get(country);
        return translationMap != null ? translationMap : TranslationTables.MASTER_TABLE;
    }

    private Map<Character,String> retrieveTranslationTable(Region region){
        checkNull(region, "Region cannot be null");
        Map<Character, String> translationMap = TranslationTables.REGION_TABLE.get(region);
        return translationMap != null ? translationMap : TranslationTables.MASTER_TABLE;
    }

}
