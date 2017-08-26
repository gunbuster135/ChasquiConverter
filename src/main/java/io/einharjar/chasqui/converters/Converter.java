package io.einharjar.chasqui.converters;

import io.einharjar.chasqui.converters.locale.Country;
import io.einharjar.chasqui.converters.locale.Language;
import io.einharjar.chasqui.converters.locale.Region;



public interface Converter {
    String convert(String s, Language language);
    String convert(String s, Country country);
    String convert(String s, Region region);
    String convert(String s);
    boolean validate(String s);
}
