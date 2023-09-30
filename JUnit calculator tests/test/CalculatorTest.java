import com.vojtechjanovec.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    Calculator calculator = new Calculator(5, 10);
    Calculator calculator2 = new Calculator(-26, 5);
    @Test
    void addition() {
        assertEquals(15, calculator.addition());
        assertEquals(-21, calculator2.addition());
    }

    @Test
    void subtraction() {
        assertEquals(-5, calculator.subtraction());
        assertEquals(-31, calculator2.subtraction());
    }

    @Test
    void multiplication() {
        assertEquals(50, calculator.multiplication());
        assertEquals(-130, calculator2.multiplication());
    }

    @Test
    void division() {
        assertEquals(0.5, calculator.division());
        assertEquals(-5.2, calculator2.division());
    }

    @Test
    void maximum() {
        assertEquals(10, calculator.maximum());
        assertEquals(5, calculator2.maximum());
    }
    @Test
    void minimum() {
        assertEquals(5, calculator.minimum());
        assertEquals(-26, calculator2.minimum());
    }

    @Test
    void percentage() {
        assertEquals(0.5, calculator.percentage());
        assertEquals(-1.3, calculator2.percentage());
    }

    @Test
    void power() {
        assertEquals(9765625, calculator.power());
        assertEquals(-11881376, calculator2.power());
    }
}