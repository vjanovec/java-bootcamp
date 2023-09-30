package com.vojtechjanovec;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.nio.charset.StandardCharsets.UTF_8;

public class Reader implements Runnable {
    Output output;
    int start;
    int part;

    public Reader(Output output, int start, int part) {
        this.output = output;
        this.start = start;
        this.part = part;
    }

    @Override
    public void run() {
        try (RandomAccessFile raf = new RandomAccessFile("src/com/vojtechjanovec/quotes713.csv", "r")) {
            raf.seek(start);
            byte[] b = new byte[part+start];
            raf.readFully(b, start, part);

            String content = new String(b);
            //System.out.println(content);
//            char[] arr = content.toCharArray();
//            System.out.println(arr.length);

//            List<Character> list = content.chars()
//                    .mapToObj(i -> (char)i)
//                    .collect(Collectors.toList());
//                    //.filter(i -> i == 'a' || i == 'e' || i == 'i' || i == 'o' || i == 'u' || i == 'y');
            int specificCount = 0;
            int generalCount = 0;
//            content.chars()
//                    .mapToObj(i -> (char)i)
//                    .map(i -> {
//                        if(i == 'a' || i == 'e' || i == 'i' || i == 'o' || i == 'u' || i == 'y') {
//                            ;
//                        }
//                    });

            for(int i=0; i<content.length(); i++) {
                if(content.charAt(i) == 'a' || content.charAt(i) == 'e' || content.charAt(i) == 'i' || content.charAt(i) == 'o' || content.charAt(i) == 'u' || content.charAt(i) == 'y' || content.charAt(i) == 'A' || content.charAt(i) == 'E' || content.charAt(i) == 'I' || content.charAt(i) == 'O' || content.charAt(i) == 'U' || content.charAt(i) == 'Y') {
                    output.add();
                }
                generalCount++;
            }
            System.out.println(Thread.currentThread().getName()+" -- Samohlasky -- "+specificCount);
            System.out.println(Thread.currentThread().getName()+" -- Vsechny znaky -- "+ generalCount);
            System.out.println("Total: "+output.getTotal());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
