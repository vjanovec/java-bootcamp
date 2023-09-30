package com.vojtechjanovec;

import java.util.ArrayList;
import java.util.List;

public class Person implements ISaveable {
    private String name;
    private int age;
    private String adress;

    public Person(String name, int age, String adress) {
        this.name = name;
        this.age = age;
        this.adress = adress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Override
    public List<String> write() {
        List<String> values = new ArrayList<String>();
        values.add(0, name);
        values.add(1, Integer.toString(age));
        values.add(2, adress);
        return values;
    }

    @Override
    public void read(List<String> savedValues) {
        this.name = savedValues.get(0);
        this.age = Integer.parseInt(savedValues.get(1));
        this.adress = savedValues.get(2);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", adress='" + adress + '\'' +
                '}';
    }
}


