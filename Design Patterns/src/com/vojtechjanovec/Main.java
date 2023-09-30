package com.vojtechjanovec;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
	// write your code here

//        final ArrayList<Object> list = new ArrayList<Object>();
//        list.add(new A(1));
//        list.add(new A(2));
//        list.add(new B(3));
//        list.add(new B(4));
//        list.add(new A(5));
//        list.add(new B(6));
//        list.add(new A(7));
//        list.add(new A(8));
//        final SimpleIterator<Object> iterator = new MySimpleIterator<Object>(list);
//
//        B a = new B(0);
//        String aClassName = a.getClass().getName();
//        while (iterator.hasNext()) {
//            Object o = iterator.next(aClassName);
//            if(o != null) {
//                System.out.println(o.toString());
//            }
//
//
//        }


        String s = "This is my String";
        char[] arr = Utility.stringToCharArr(s);
        for(char c : arr) {
            System.out.print(c+" ");
        }
        System.out.println();
        System.out.println(Utility.charArrToString(arr));

        System.out.println(UtilityPassword.generate());
    }
}
