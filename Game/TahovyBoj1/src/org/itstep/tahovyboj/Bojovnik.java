package org.itstep.tahovyboj;

public class Bojovnik {

    private String jmeno;
    private int zivot;
    private int maxZivot;
    private int utok;
    private int obrana;
    private Kostka kostka;

    public Bojovnik(String jmeno, int zivot, int utok, int obrana, Kostka kostka) {
        this.jmeno = jmeno;
        this.zivot = zivot;
        this.maxZivot = zivot;
        this.utok = utok;
        this.obrana = obrana;
        this.kostka = kostka;
    }

    @Override
    public String toString() {
        return this.jmeno;
    }

    public boolean isNazivu() {
        return this.zivot > 0;
    }

    public String getGrafickyZivot() {
        String s = "[";
        int celkem = 20;
        double pocet = Math.round(((double) this.zivot / this.maxZivot) * celkem);
        if ((pocet == 0) && (isNazivu())) {
            pocet = 1;
        }
        for (int i = 0; i < pocet; i++) {
            s += "#";
        }
        for (int i = 0; i < celkem - pocet; i++) {
            s += " ";
        }
        s += "]";
        return s;
    }

    public void branSe(int uder) {
        int zraneni = uder - (this.obrana + this.kostka.hod());
        if (zraneni > 0) {
            this.zivot -= zraneni;
            if (this.zivot <= 0) {
                this.zivot = 0;
            }
        }
    }

    public void utoc(Bojovnik souper) {
        int uder = this.utok + this.kostka.hod();
        souper.branSe(uder);
    }

}
