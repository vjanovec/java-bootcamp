package com.vojtechjanovec;

public class Uzivatel {
    private String jmeno;
    private String heslo;
    private boolean prihlaseny;
    private static int id = 1;
    private static int minimalniDelkaHesla = 6;

    public Uzivatel(String jmeno, String heslo) {
        this.jmeno = jmeno;
        this.heslo = heslo;
        this.prihlaseny = false;
        this.id++;
    }
    public static boolean zvalidujHeslo(String heslo) {
        return (heslo.length() >= minimalniDelkaHesla);
    }


    public boolean logIn(String password) {
        if(heslo.equals(password)) {
            prihlaseny = true;
            return true;
        } else {
            return false;
        }
    }
}
