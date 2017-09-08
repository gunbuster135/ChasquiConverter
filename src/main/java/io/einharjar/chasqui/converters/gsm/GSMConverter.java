package io.einharjar.chasqui.converters.gsm;

import io.einharjar.chasqui.converters.locale.Country;
import io.einharjar.chasqui.converters.locale.Language;
import io.einharjar.chasqui.converters.Converter;
import io.einharjar.chasqui.converters.locale.Region;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;

import static io.einharjar.chasqui.converters.util.Helper.*;

public class GSMConverter implements Converter {

    private static final Character[] CHAR_TABLE = new Character[]{
            '@', '\u00a3', '$', '\u00a5', '\u00e8', '\u00e9', '\u00f9', '\u00ec',
            '\u00f2', '\u00c7', '\n', '\u00d8', '\u00f8', '\r', '\u00c5', '\u00e5',
            '\u0394', '_', '\u03a6', '\u0393', '\u039b', '\u03a9', '\u03a0', '\u03a8',
            '\u03a3', '\u0398', '\u039e', ' ', '\u00c6', '\u00e6', '\u00df', '\u00c9',
            ' ', '!', '"', '#', '\u00a4', '%', '&', '\'',
            '(', ')', '*', '+', ',', '-', '.', '/',
            '0', '1', '2', '3', '4', '5', '6', '7',
            '8', '9', ':', ';', '<', '=', '>', '?',
            '\u00a1', 'A', 'B', 'C', 'D', 'E', 'F', 'G',
            'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
            'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
            'X', 'Y', 'Z', '\u00c4', '\u00d6', '\u00d1', '\u00dc', '\u00a7',
            '\u00bf', 'a', 'b', 'c', 'd', 'e', 'f', 'g',
            'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
            'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
            'x', 'y', 'z', '\u00e4', '\u00f6', '\u00f1', '\u00fc', '\u00e0',
            '\f', '^', '{', '}', '\\', '[', '~', ']', //Here begins chars in extended table
            '|', '\u20ac'
    };
    public static final HashSet<Character> CHARACTERS_ALLOWED = new HashSet<Character>(Arrays.asList(CHAR_TABLE));

    public GSMConverter() {

    }

    public String convert(String s, Language lang) {
        if (isBlank(s)) {
            return s;
        }
        return convert(s, retrieveTranslationTable(lang));
    }

    public String convert(String s, Country country) {
        if (isBlank(s)) {
            return s;
        }
        return convert(s, retrieveTranslationTable(country));
    }

    public String convert(String s, Region region) {
        if (isBlank(s)) {
            return s;
        }
        return convert(s, retrieveTranslationTable(region));
    }

    public String convert(String s) {
        if (isBlank(s)) {
            return s;
        }
        return convert(s, TranslationTables.MASTER_TABLE);
    }

    public boolean validate(String s) {
        return false;
    }

    private String convert(String s, Map<Character, String> translationMap) {
        StringBuilder translatedString = new StringBuilder();

        for (Character c : s.toCharArray()) {
            String correspondingValue = translationMap.get(c);
            if (correspondingValue == null) {
                if (CHARACTERS_ALLOWED.contains(c)) {
                    translatedString.append(c);
                }
            } else {
                translatedString.append(correspondingValue);
            }
        }
        return translatedString.toString();
    }

    private Map<Character, String> retrieveTranslationTable(Language lang) {
        checkNull(lang, "Language cannot be null");
        Map<Character, String> translationMap = TranslationTables.LANGUAGE_TABLE.get(lang);
        return translationMap != null ? translationMap : TranslationTables.MASTER_TABLE;
    }

    private Map<Character, String> retrieveTranslationTable(Country country) {
        checkNull(country, "Country cannot be null");
        Map<Character, String> translationMap = TranslationTables.COUNTRY_TABLE.get(country);
        return translationMap != null ? translationMap : TranslationTables.MASTER_TABLE;
    }

    private Map<Character, String> retrieveTranslationTable(Region region) {
        checkNull(region, "Region cannot be null");
        Map<Character, String> translationMap = TranslationTables.REGION_TABLE.get(region);
        return translationMap != null ? translationMap : TranslationTables.MASTER_TABLE;
    }

}
