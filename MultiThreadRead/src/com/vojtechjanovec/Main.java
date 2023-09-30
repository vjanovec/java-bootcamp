package com.vojtechjanovec;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Path;

public class Main {

    // samohlasky = 297644064
    // vsechny znaky = 992380856

    // 1 thread 8s
    // 2 threads 8,18s // first < 5s
    // 3 threads 8,20s // first < 4s

    // 1 thread 8,53
    // 2 threads 10,80
    // 3 threads 19,16

    public static void main(String[] args) {
	// write your code here
        long startTime = System.nanoTime();
        try(RandomAccessFile raf = new RandomAccessFile("src/com/vojtechjanovec/quotes713.csv", "r")) {
            System.out.println("" + raf.length());
            long fileLength = raf.length();
            int part = (int) (fileLength);
            Output output = new Output();
            Thread reader1 = new Thread(new Reader(output, 0, part));
//            Thread reader2 = new Thread(new Reader(output, part, part));
//            Thread reader3 = new Thread(new Reader(output, part*2, part));
//            Thread reader4 = new Thread(new Reader(output, part*3, part));
//            Thread reader5 = new Thread(new Reader(output, part*4, part));
            reader1.start();
//            reader2.start();
//            reader3.start();
//            reader4.start();
//            reader5.start();
            reader1.join();
//            reader2.join();
//            reader3.join();
            long duration = System.nanoTime() - startTime;
            System.out.println("Bez:" +duration/1e6);
        } catch(IOException | InterruptedException e) {
            e.printStackTrace();
        }




    }
}
