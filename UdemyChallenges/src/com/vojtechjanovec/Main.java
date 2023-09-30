package com.vojtechjanovec;

import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
    Person person1 = new Person("Karel", 40, "Stare mesto");
    Person person2 = new Person("Tomáš", 25, "Řeporyje");
    System.out.println(person1);
    System.out.println(person2);
    List<String> list = person1.write();
    person2.read(list);
    System.out.println(person1);
    System.out.println(person2);
    }
}
