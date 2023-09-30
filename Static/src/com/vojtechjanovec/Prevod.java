package com.vojtechjanovec;

public class Prevod {

    private Prevod() {
    }

    public static double degToRad(double deg) {
        return deg*Math.PI/180;
    }

    public static double radToDeg(double rad) {
        return rad*180/Math.PI;
    }
}
