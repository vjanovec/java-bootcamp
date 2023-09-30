/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vlaknasamohlas;

import java.util.Arrays;

/**
 *
 * @author masic
 */
public class Counter {

    private int[] count = new int[5];//a,e,i,o,u

    public Counter() {
        super();
    }

    private void debugPrint() {
        System.out.println("------counter s-------");
        Arrays.stream(count).forEach(System.out::println);
        System.out.println("----------------------");

    }

//    public void addA(int i) {
//        if (i > 0) {
//            count[0] += i;
//            debugPrint();
//
//        }
//    }
//
//    public void addE(int i) {
//        if (i > 0) {
//            count[1] += i;
//            debugPrint();
//
//        }
//    }
//
//    public void addI(int i) {
//        if (i > 0) {
//            count[2] += i;
//            debugPrint();
//
//        }
//    }
//
//    public void addO(int i) {
//        if (i > 0) {
//            count[3] += i;
//            debugPrint();
//
//        }
//    }
//
//    public void addU(int i) {
//        if (i > 0) {
//            count[4] += i;
//            debugPrint();
//
//        }
//    }
    synchronized public void addA(int i) {
        if (i > 0) {
            //count[0] = i;
            count[0] += i;
            notify();
            //debugPrint();
        }
    }

    synchronized public void addE(int i) {
        if (i > 0) {
            count[1] += i;
            notify();
            //debugPrint();

        }
    }

    synchronized public void addI(int i) {
        if (i > 0) {
            count[2] += i;
            notify();
            //debugPrint();

        }
    }

    synchronized public void addO(int i) {
        if (i > 0) {
            count[3] += i;
            notify();
           // debugPrint();
        }
    }

    synchronized public void addU(int i) {
        if (i > 0) {
            count[4] += i;
            notify();
            //debugPrint();
        }
    }

    public int[] getCount() {
        return count;
    }

}
