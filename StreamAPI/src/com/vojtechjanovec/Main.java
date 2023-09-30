package com.vojtechjanovec;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class Main {

    public static void main(String[] args) {
	// write your code here
        List<String> jmena = Arrays.asList("David", "Martin", "Dan", "Petr", "Vratislav", "Eliska");
        jmena.stream()
                .filter(jmeno -> jmeno.length() > 5)
                .collect(Collectors.toList())
                .forEach(System.out::println);


        List<Integer> cisla = Arrays.asList(1, 8, 4, 2, 3, 7, 9, 54, 12, 17, 19, 91, 23, 71, 80, 98, 10);
        System.out.println();
        cisla.stream()
                .filter(cislo -> cislo % 2 == 0)
                .collect(Collectors.toList())
                .forEach(cislo -> System.out.print(cislo+" "));

        DoubleStream.generate(()-> Math.random()*10).limit(10).forEach(System.out::println);
    }
}
