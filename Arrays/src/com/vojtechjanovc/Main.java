package com.vojtechjanovc;

public class Main {

    public static void main(String[] args) {
        // write your code here
        String input = "Toto je moje veta, je ktere to detekuje souhlasky samohlasky a specialni znaky >[]1$%$^&";
        System.out.println(input);
        input = input.toLowerCase();

        int pocetSouhlasek = 0;
        int pocetSamohlasek = 0;
        int pocetSpecialnichZnaku = 0;
        String souhlasky = "hchkrdtnžšcčřjďťňbflmpsvz";
        String samohlasky = "aeiouáéíóúůyý";

        for (char c : input.toCharArray()) {
            if (souhlasky.contains(String.valueOf(c))) {
                pocetSouhlasek++;
            } else if (samohlasky.contains(String.valueOf(c))) {
                pocetSamohlasek++;
            } else {
                pocetSpecialnichZnaku++;
            }
        }
        System.out.println("Počet souhlásek: "+pocetSouhlasek+". Počet samohlásek: "+pocetSamohlasek+". Počet speciálních znaků: "+pocetSpecialnichZnaku);

        for(int i=33; i<255; i++) {
            System.out.println(i+":"+((char) i));
        }



    }
}
