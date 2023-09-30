import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KalkulackaTest {
    private Kalkulacka kalkulacka;

    @BeforeEach
    void setUp() {
         kalkulacka = new Kalkulacka();
    }

    @Test
    void scitani() {
        assertEquals(5, kalkulacka.scitani(3, 2));
        assertEquals(6, kalkulacka.scitani(3, 3));
    }

    @Test
    void odcitani() {
        assertEquals(5, kalkulacka.odcitani(10,5));
        assertEquals(7, kalkulacka.odcitani(18, 11));
    }

    @Test
    void nasobeni() {
        assertEquals(9, kalkulacka.nasobeni(3, 3));
        assertEquals(72, kalkulacka.nasobeni(18, 4));
    }

    @Test
    void deleni() {
        assertEquals(3, kalkulacka.deleni(9, 3));
        assertEquals(1.5, kalkulacka.deleni(3, 2));
    }
}