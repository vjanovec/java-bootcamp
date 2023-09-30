package com.vojtechjanovec;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class TextClass {

    public static void main(String[] args) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("soubor.txt"))) {
            for(int i=0; i<10; i++) {
                bw.write("Pripsany radek "+ i);
                bw.newLine();
                bw.flush();
            }
        } catch (Exception e) {
            System.err.println("Do souboru se nepovedlo zapsat.");
        }

        try(BufferedReader br = new BufferedReader(new FileReader("soubor.txt"))) {
            String s = "";
            while((s = br.readLine()) != null) {
                System.out.println(s);
            }

        } catch(Exception e) {

        }
    }

}
