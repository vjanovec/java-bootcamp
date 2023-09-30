package com.vojtechjanovec;

import java.util.Random;

public final class UtilityPassword {
    private UtilityPassword() {
    }

    // 8 znaku
    // cislo
    // velke pismeno

    // 97-122
    public static String generate() {
        Random random = new Random();
        String password = "";
        for(int i=0; i<8; i++) {
            int rnd = random.nextInt(25)+97;
            password += (char) rnd;
        }
        int rnd = random.nextInt(8);
        char[] passArr = Utility.stringToCharArr(password);
        for(int i=0; i<rnd; i++) {
            int rnd2 = random.nextInt(10);
            passArr[rnd] = (char) (rnd2+'0');
        }
        rnd = random.nextInt(8);
        for(int i=0; i<rnd; i++) {
            int rnd2 = random.nextInt(8);
            passArr[rnd2] = Character.toUpperCase(passArr[rnd2]);
        }

        return Utility.charArrToString(passArr);
    }
}
