package com.vojtechjanovec;

public class Soldier {

    private String name;
    private int hp;
    private int ammo;

    public Soldier() {
        this.name = "NoBody";
        this.hp = 3;
        this.ammo = 100;
    }

    public Soldier(String name) {
        this.name = name;
        this.hp = 3;
        this.ammo = 100;
    }

    public Soldier(String name, int hp, int ammo) {
        this.name = name;
        if(hp>0) {
            this.hp = hp;
        } else {
            System.out.println("Constructor wrong value");
        }
        if(ammo>=0 && ammo<=500) {
            this.ammo = ammo;
        } else {
            System.out.println("Constructor wrong value");
        }

    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getAmmo() {
        return ammo;
    }

    @Override
    public String toString() {
        return "com.vojtechjanovec.Vojak{" +
                "name='" + name + '\'' +
                ", hp=" + hp +
                ", ammo=" + ammo +
                '}';
    }
}


