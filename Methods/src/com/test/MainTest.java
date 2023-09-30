package com.test;

import com.vojtechjanovec.Main;

import static org.junit.Assert.*;

public class MainTest {


    @org.junit.Test
    public void trianglePerimeter() {
        assertEquals(20.0, Main.trianglePerimeter(5,6,9), 0);
        assertEquals(149.0, Main.trianglePerimeter(56,4,89), 0);
        assertEquals(60.0, Main.trianglePerimeter(56,4,0), 0);
    }

    @org.junit.Test
    public void trianglePerimeter1() {
        assertEquals(8, Main.trianglePerimeter(2, 3), 0);
        assertEquals(16, Main.trianglePerimeter(2, 7), 0);
        assertEquals(9, Main.trianglePerimeter(9, 0), 0);
    }

    @org.junit.Test
    public void trianglePerimeter2() {
        assertEquals(18, Main.trianglePerimeter(6), 0);
        assertEquals(6, Main.trianglePerimeter(2), 0);
        assertEquals(90, Main.trianglePerimeter(30), 0);

    }

    @org.junit.Test
    public void cuboidDiagonal() {
        assertEquals(5.66, Main.cuboidDiagonal(4, 4, 4), 0.01);
        assertEquals(17, Main.cuboidDiagonal(12, 12, 12), 0.1);


    }

    @org.junit.Test
    public void cuboidDiagonal2() {
        assertEquals(20.8, Main.cuboidDiagonal2(12, 12, 12), 0.1);
    }

    @org.junit.Test
    public void textAnalysis() {
    }
}