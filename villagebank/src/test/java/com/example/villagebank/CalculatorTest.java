package villagebank.src.test.java.com.example.villagebank;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import villagebank.src.main.Calculator;
import static org.junit.Assert.*;


public class CalculatorTest {

    private Calculator calculator = new Calculator();

    @Test
    public void getSum() {
        assertEquals(15, calculator.getSum(5,7));
    }

    @Test
    public void getDivide() {
        assertEquals(20, calculator.getDivide(100,5));
    }

    @Test
    public void getMupltiple() {
        assertEquals(100, calculator.getMupltiple(20, 5));
    }
}