package edu.umb.cs680.hw01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimeGeneratorTest {
    
    @Test
    public  void primesFrom1to30() {
        PrimeGenerator primenumbers=new PrimeGenerator(1,30);
        primenumbers.generatePrimes();
        Long[] expectprimes= {2L,3L,5L,7L,11L, 13L, 17L, 19L, 23L, 29L};
        assertArrayEquals(expectprimes,primenumbers.getPrimes().toArray());
    }

    @Test
    public void isprime() {
        PrimeGenerator primenumbers=new PrimeGenerator(1,100);
        boolean expected =true;
        boolean actual =primenumbers.isPrime(3);
        assertEquals(expected,actual);
    }

    @Test
    public void iseven() {
        PrimeGenerator primenumbers=new PrimeGenerator(1,20);
        boolean expected =true;
        boolean actual =primenumbers.isEven(10);
        assertEquals(expected,actual);
    }

    @Test
    public  void primesFrom1to10() {
        PrimeGenerator primenumbers = new PrimeGenerator(1,10);
        primenumbers.generatePrimes();
        Long[] expectprimes= {2L,3L,5L,7L};
        assertArrayEquals(expectprimes,primenumbers.getPrimes().toArray());
    }

    

}

