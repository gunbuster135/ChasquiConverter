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

    public static boolean isBlank(final CharSequence cs) {
        if (cs == null || cs.length() == 0) {
            return true;
        }
        for (int i = 0; i < cs.length(); i++) {
            if (!Character.isWhitespace(cs.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
