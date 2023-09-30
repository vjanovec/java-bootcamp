package org.itstep.tahovyboj;

public class TahovyBoj {

    public static void main(String[] args) {
        Kostka desetistenna = new Kostka(10);
        Bojovnik bojovnik = new Bojovnik("Zalgoren", 100, 20, 10, desetistenna);

        System.out.println("bojovnik " + bojovnik);
        System.out.println("je zivy? " + bojovnik.isNazivu());
        System.out.println("zivot: " + bojovnik.getGrafickyZivot());

        bojovnik.utoc(bojovnik);
        System.out.println("zivot po utoku: " + bojovnik.getGrafickyZivot());
    }
}
