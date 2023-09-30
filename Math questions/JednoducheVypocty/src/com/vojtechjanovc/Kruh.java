package com.vojtechjanovc;

public class Kruh {

    double r;
    double d;
    double obvod;
    double obsah;

    public Kruh(double r, double d, double obvod, double obsah) {
        if (r != 0) {
            vypocet(r);
        } else if (d != 0) {
            vypocet(d / 2);
        } else if (obvod != 0) {
            vypocet(obvod / 2 / Math.PI);
        } else if(obsah != 0) {
            vypocet(Math.sqrt(obsah/Math.PI));
        } else {
            System.out.println("Zadaná hodnota byla u všech argumentů 0");
        }
    }


    public void vypocet(double r) {
        if (r != 0) {
            this.r = r;
            this.d = 2 * r;
            this.obvod = 2 * Math.PI * r;
            this.obsah = Math.PI * Math.pow(r, 2);
        }
    }

    @Override
    public String toString() {
        return "Kruh{" +
                "r=" + r +
                ", d=" + d +
                ", obvod=" + obvod +
                ", obsah=" + obsah +
                '}';
    }
}
