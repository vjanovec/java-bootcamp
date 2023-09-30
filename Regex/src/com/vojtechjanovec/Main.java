package com.vojtechjanovec;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main( String args[] ) {
        // String to be scanned to find the pattern.
        String line = "Ministerstvo školství, mládeže a tělovýchovy Karmelitská 7 118 12 Praha 1 tel. ústředna: +420 234 811 111 PhDr. Ivanka Jurečková, CSc. tel. : +420 234811 628 PhDr. Dagmar Lančová tel. : +420 234811 628 tel. : 004202348119 725 e-mail: info@msmt.cz";
        String pattern = "(\\+|(00))420\\s*(\\d\\s*){8}\\d";

        // Create a Pattern object
        Pattern r = Pattern.compile(pattern);

        // Now create matcher object.
        Matcher m = r.matcher(line);
        System.out.println(m.find());
        int count = 0;

        while(m.find()) {
            count++;
            System.out.println("Match number "+count);
//            System.out.println("start(): "+m.start());
//            System.out.println("end(): "+m.end());
            System.out.println(line.substring(m.start(), m.end()));
        }


    }
}