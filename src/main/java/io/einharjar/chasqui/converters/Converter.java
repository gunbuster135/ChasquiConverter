package io.einharjar.chasqui.converters;

import io.einharjar.chasqui.converters.target.Country;
import io.einharjar.chasqui.converters.target.Language;
import io.einharjar.chasqui.converters.target.Region;



public interface Converter {
    String convert(String s, Language language);
    String convert(String s, Country country);
    String convert(String s, Region region);
    String convert(String s);
}
