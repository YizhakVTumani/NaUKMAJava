import org.junit.jupiter.api.Test;
import practice4.Calculator;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class TestCalc {
    @Test
    void test(){
        Calculator calc = new Calculator();
        assertEquals((double)3, (double)calc.divide(8.0,2.0));
    }

    @Test
    void test2(){
        Calculator calc = new Calculator();
        assertThrows(IllegalArgumentException.class, () -> calc.divide(4, 0));
    }

}
