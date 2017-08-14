package chasqui.converters;

import chasqui.converters.target.Country;
import chasqui.converters.target.Language;
import chasqui.converters.target.Region;

/**
 * Created by omar on 2017-08-14.
 */
public interface PayloadConverter {
    String convert(String s, Language language);
    String convert(String s, Country country);
    String convert(String s, Region region);
    String convert(String s);

}
