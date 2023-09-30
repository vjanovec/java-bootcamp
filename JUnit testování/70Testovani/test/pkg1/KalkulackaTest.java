/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import pkg1.Kalkulacka;

/**
 * Testuje jednoduchou kalkulačku
 */
public class KalkulackaTest {
    
    @Rule
    public ExpectedException vyjimka = ExpectedException.none();
    
    /**
     * Instance kalkulačky
     */
    private Kalkulacka kalkulacka;
    
    public KalkulackaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        // Nová kalkulačka je vytvořena před každým testem pro garantování jejich nezávislosti
        kalkulacka = new Kalkulacka();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void scitani() {
        assertEquals(2, kalkulacka.secti(1, 1), 0);
        assertEquals(1.42, kalkulacka.secti(3.14, -1.72), 0.001);
        assertEquals(2.0/3, kalkulacka.secti(1.0/3, 1.0/3), 0.001);
    }

    @Test
    public void odcitani() {
        assertEquals(0, kalkulacka.odecti(1, 1), 0);
        assertEquals(4.86, kalkulacka.odecti(3.14, -1.72), 0.001);
        assertEquals(2.0/3, kalkulacka.odecti(1.0/3, -1.0/3), 0.001);
    }

    @Test
    public void nasobeni() {
        assertEquals(2, kalkulacka.vynasob(1, 2), 0);
        assertEquals(-5.4008, kalkulacka.vynasob(3.14, -1.72), 0.001);
        assertEquals(0.111, kalkulacka.vynasob(1.0/3, 1.0/3), 0.001);
    }

    @Test
    public void deleni() {
        assertEquals(2, kalkulacka.vydel(4, 2), 0);
        assertEquals(-1.826, kalkulacka.vydel(3.14, -1.72), 0.001);
        assertEquals(1, kalkulacka.vydel(1.0/3, 1.0/3), 0);
    }

    @Test(expected=IllegalArgumentException.class)
    public void deleniVyjimka() {
        kalkulacka.vydel(2, 0);
    }
 
      @Test
    public void deleniInt() {
        assertEquals(1, kalkulacka.vydel(4, 5), 0);
        
    }

    @Test
    public void secti() {
    }

    @Test
    public void odecti() {
    }

    @Test
    public void vynasob() {
    }

    @Test
    public void vydel() {
    }

    @Test
    public void vydel1() {
    }
}
