import org.example.Factorial;
import org.example.MyFactorialException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FactorialTest {

    @Test
    public void testFactorialOfZero() throws MyFactorialException {
        int result = Factorial.factorial(0);
        assertEquals(1, result);
    }

    @Test
    public void testFactorialOfPositiveNumber() throws MyFactorialException {
        int result = Factorial.factorial(7);
        assertEquals(5040, result);
    }


    @Test
    public void testFactorialExceptionFor20() {
        try {
            Factorial.factorial(20);
            fail("Expected MyFactorialException to be thrown");
        } catch (MyFactorialException e) {
            assertEquals("Number must be less than 20.", e.getMessage());
        }
    }
}
