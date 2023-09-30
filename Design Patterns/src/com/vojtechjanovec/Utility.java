package com.vojtechjanovec;

public final class Utility {
    private Utility() {
    }

    public static char[] stringToCharArr(String s) {
        return s.toCharArray();
    }

    public static String charArrToString(char[] arr) {
        return new String(arr);
    }
}
