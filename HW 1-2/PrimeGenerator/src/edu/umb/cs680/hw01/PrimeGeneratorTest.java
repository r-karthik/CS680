package edu.umb.cs680.hw1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PrimeGeneratorTest{

    @Test
    public void is4even(){
        PrimeGenerator prime = new PrimeGenerator(1, 10);
        boolean actual = prime.isEven(4);
        assertTrue(actual);
    }


    @Test
    public void is11Prime(){
        PrimeGenerator prime = new PrimeGenerator(10, 20);
        boolean actual = prime.isPrime(11);
        assertTrue(actual);
    }

    @Test
    public void primesFrom30to50(){
        PrimeGenerator prime = new PrimeGenerator(30, 50);
        prime.generatePrimes();
        Long[] expectedValues = {31L, 37L, 41L, 43L, 47L};
        assertArrayEquals(expectedValues, prime.getPrimes().toArray());
    }

    @Test
    public void negativePrimesTest(){
        try {
            PrimeGenerator prime = new PrimeGenerator(-20, 6);
        }
        catch(Exception exception){
            assertEquals("Wrong input values: from=-20 to=6", exception.getMessage());
        }
    }
}
