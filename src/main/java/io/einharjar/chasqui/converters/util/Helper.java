package io.einharjar.chasqui.converters.util;

/**
 * Created by omar on 2017-08-26.
 */
public class Helper {
    public static void checkNull(Object obj, String message){
        if(obj == null) throw new IllegalArgumentException(message);
    }

    public static void checkNull(Object obj){
        if(obj == null) throw new IllegalArgumentException();
    }
}
