/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vlaknasamohlas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author masic
 */
public class Boss extends Thread {

    private Counter cn;
    ArrayList<Worker> workers = new ArrayList<Worker>();
    private File temp;
    private int minT = 1;
    private int maxT = 1;
    private long divider = 1024 * 1024 * 10;//10MB
    private ArrayList<String> fileContent = new ArrayList<>();

    public Boss(String path) throws FileNotFoundException {

        temp = new File(path);

        boolean exists = temp.exists();
        loadFile(path);
        cn = new Counter();
        //this.divideTast();
        start();

        System.out.println("Temp file exists : " + exists);

    }

    private void divideTast() throws FileNotFoundException {
        long fileSize = temp.length();
        long countT = this.minT;
        long partSize = 0;
        if (fileSize / this.divider > this.minT) {
            countT = this.maxT;

        }

        partSize = fileSize / countT;

        for (long i = 0; i < countT; i++) {

            workers.add(
                    new Worker(i,
                            i * partSize,
                            temp.getAbsolutePath(),
                            (i + 1) * partSize,
                            this.cn
                    )
            );

        }

    }

    @Override
    public void run() {
        long startTime = System.nanoTime();
        try {
            divideTast();
            for (Worker w : workers) {//čekám na všechny
                w.join();

            }
            System.out.println("-------------");
            Arrays.stream(this.getReSDult()).forEach(System.out::println);
            System.out.println("-------------");
            long duration = System.nanoTime() - startTime;
            System.out.println("Bez:" +duration/1e6);
        } catch (FileNotFoundException ex) {
            System.out.println("Worker id: " + getId() + " has been created exception:" + ex.getMessage());
            Logger.getLogger(Boss.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            System.out.println("Worker id: " + getId() + " has been created exception:" + ex.getMessage());
            Logger.getLogger(Boss.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    protected void waiting() {

    }

    public int[] getReSDult() {
        return cn.getCount();
    }

    private void loadFile(String filePath) throws FileNotFoundException {
        FileInputStream is = new FileInputStream(filePath);
        BufferedReader br;
        String enconding = "UTF-8";
        int i = 0;
        try {
            br = new BufferedReader(new InputStreamReader(is, enconding));

            String s;
            while ((s = br.readLine()) != null) {
//                i++;
//                if ((i % 100) == 0) {
//                    System.out.println("ř" + (i));
//                }

                fileContent.add(s);
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

    }
}
