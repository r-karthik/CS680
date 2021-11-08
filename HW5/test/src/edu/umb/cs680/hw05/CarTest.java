package edu.umb.cs680.hw05;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    private String[] carToStringArray(Car car) {
        String[] carInfo =  {
                car.getMake(), car.getModel(), Integer.toString(car.getYear())
        };
        return carInfo;
    }

    @Test
    public void verifyCarEqualityWithMakeModelYear()
    {
        String[] expected = {"Tata","nano","2014"};
        Car actual= new Car("Tata","nano",15,2014,100000);
        assertArrayEquals(expected,carToStringArray(actual) );
    }

    @Test
    public void verifyCarNotEqualityWithMakeModelYear()
    {
        String[] expected = {"Tata","nano","2014"};
        Car actual= new Car("Toyota","Fortuner",15,2014,100000);
        assertNotEquals(expected,carToStringArray(actual) );
    }

}