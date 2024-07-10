package org.example;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class FactorialTest {

    @Test
    public void testFactorialOfZero() throws MyFactorialException {
        int result = Factorial.factorial(0);
        assertEquals(result, 1);
    }

    @Test
    public void testFactorialOfPositiveNumber() throws MyFactorialException {
        int result = Factorial.factorial(7);
        assertEquals(result, 5040);
    }

    @Test(expectedExceptions = MyFactorialException.class)
    public void testFactorialOf20() throws MyFactorialException {
        int result = Factorial.factorial(20);
    }

    @Test(expectedExceptions = MyFactorialException.class)
    public void testFactorialOfNegativeNumber() throws MyFactorialException {
        Factorial.factorial(-1);
    }
}