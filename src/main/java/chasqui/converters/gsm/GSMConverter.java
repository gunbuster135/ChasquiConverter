package chasqui.converters.gsm;

import chasqui.converters.target.Country;
import chasqui.converters.target.Language;
import chasqui.converters.PayloadConverter;
import chasqui.converters.target.Region;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

public class GSMConverter implements PayloadConverter {

    public Map<Integer, Map<Character, String>> mergedTranslationMapCache;

    public String convert(String s, Language lang) {
        if(StringUtils.isBlank(s)){
            return s;
        }
        if(lang == null){
            throw new IllegalArgumentException("Language cannot be null");
        }
        Map<Character, String> translationMap = TranslationTables.LANGUAGE_TABLE.get(lang);
        if(translationMap == null){
            throw new IllegalArgumentException("Language does not have a corresponding translation table");
        }
        return convert(s, translationMap);
    }

    public String convert(String s, Country country) {
        if(StringUtils.isBlank(s)){
            return s;
        }
        if(country == null){
            throw new IllegalArgumentException("Country cannot be null");
        }
        Map<Character, String> translationMap = TranslationTables.COUNTRY_TABLE.get(country);
        if(translationMap == null){
            throw new IllegalArgumentException("Country does not have a corresponding translation table");
        }
        return convert(s, translationMap);
    }

    public String convert(String s, Region region) {
        if(StringUtils.isBlank(s)){
            return s;
        }
        if(region == null){
            throw new IllegalArgumentException("Region cannot be null");
        }
        Map<Character, String> translationMap = TranslationTables.REGION_TABLE.get(region);
        if(translationMap == null){
            throw new IllegalArgumentException("Region does not have a corresponding translation table");
        }
        return convert(s, translationMap);
    }

    public String convert(String s){
        if(StringUtils.isBlank(s)){
            return s;
        }
        return convert(s, TranslationTables.MASTER_TABLE);
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
}
