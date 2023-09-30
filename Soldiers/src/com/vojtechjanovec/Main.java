package com.vojtechjanovec;

import java.util.*;

public class Main {

    public static Scanner sc;

    public static void main(String[] args) {
	// write your code here
        Soldier soldier1 = new Soldier();
        Soldier soldier2 = new Soldier("Raien", 5, 60);

        sc = new Scanner(System.in);
        System.out.println("Enter soldier name: ");
        String soldierName = sc.nextLine();
        System.out.println("Enter soldier hp: ");
        int soldierHp = sc.nextInt();
        System.out.println("Enter soldier ammo: ");
        int soldierAmmo = sc.nextInt();
        Soldier soldier3 = new Soldier(soldierName, soldierHp,soldierAmmo);

        System.out.println(soldier1 +"\n"+ soldier2 +"\n"+ soldier3);

        List<Soldier> soldiers = new ArrayList<>();
        soldiers.add(soldier1);
        soldiers.add(soldier2);
        soldiers.add(soldier3);
        Collections.sort(soldiers, new Comparator<Soldier>() {
            @Override
            public int compare(Soldier o1, Soldier o2) {
                if (o1.getAmmo() == o2.getAmmo()) {
                    return 0;
                } else if (o1.getAmmo() > o2.getAmmo()) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });

        for(Soldier soldier : soldiers) {
            System.out.println(soldier);
        }

    }
}
