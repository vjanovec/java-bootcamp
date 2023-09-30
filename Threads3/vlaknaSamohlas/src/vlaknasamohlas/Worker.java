/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vlaknasamohlas;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class Worker extends Thread {

    private int[] count = new int[5];//a,e,i,o,u
    private long start = 0;
    private long lenght = 0;
    InputStream is;
    BufferedReader br;
    String enconding = "UTF-8";
    private Counter cn;

    public Worker(long id, long start, String filePath, 
            long lenght, Counter cn) throws FileNotFoundException {
        super("Worker " + id);
        this.start = start;
        this.lenght = lenght;
        is = new FileInputStream(filePath);
        this.cn = cn;
        /*    
        System.out.println("Worker id: " + id + " has been created threadID:" + getId());
        System.out.println(start + ":::"+lenght);
        */
        start();
    }

    @Override
    public void run() {
        char ch = 0;
        int i;
        long x=0;
        try {
            br = new BufferedReader(new InputStreamReader(is, enconding));
            if (start>0) br.skip(start);
            
           
            while ((i = br.read()) != -1) {
                if (x==this.lenght) break;
                ch = (char) i;
                //System.out.print(ch);   
                switch (ch) {
                    case 'a':
                    case 'A':
                        this.count[0]++;
                        break;
                    case 'e':
                    case 'E':
                        this.count[1]++;
                        break;
                    case 'i':
                    case 'I':
                        this.count[2]++;
                        break;
                    case 'o':
                    case 'O':
                        this.count[3]++;
                        break;
                    case 'u':
                    case 'U':
                        this.count[4]++;
                        break;
                    default:
                        break;
                }
            }
            br.close();
            is.close();

        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Worker id: " + getId() + " has been created exception:" + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Worker id: " + getId() + " has been created exception:" + ex.getMessage());
            Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
        }
        /*System.out.println("Worker id: " + getId() + "...\n"
                + this.count[0] + "\n"
                + this.count[1] + "\n"
                + this.count[2] + "\n"
                + this.count[3] + "\n"
                + this.count[4] + "\n"
                + "/...");
                */
        cn.addA(this.count[0]);
        cn.addE(this.count[1]);
        cn.addI(this.count[2]);
        cn.addO(this.count[3]);
        cn.addU(this.count[4]);
        //System.out.println("Worker id: " + getId() + " has been finished work");
    }

    public int[] getValue() {
        return count;
    }

    public void setEnconding(String enconding) {
        this.enconding = enconding;
    }

    public String getEnconding() {
        return enconding;
    }

}
