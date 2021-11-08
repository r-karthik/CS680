package edu.umb.cs680.hw03;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class PrimeGeneratorTest {

    @Test
    public void isprime() {
        PrimeGenerator primenumbers=new PrimeGenerator(1,100);
        boolean expected =true;
        boolean actual =primenumbers.isPrime(3);
        assertEquals(expected,actual);

    }

    @Test
    public  void constructortest() {
        PrimeGenerator primenumbers=new PrimeGenerator(20,60);
        primenumbers.generatePrimes();
        Long[] expectprimes= {23L, 29L, 31L, 37L, 41L, 43L, 47L, 53L, 59L};
        assertArrayEquals(expectprimes,primenumbers.getPrimes().toArray());
    }

    @Test
    public void iseven() {
        PrimeGenerator primenumbers=new PrimeGenerator(1,20);
        boolean expected =true;
        boolean actual =primenumbers.isEven(10);
        assertEquals(expected,actual);
    }


}