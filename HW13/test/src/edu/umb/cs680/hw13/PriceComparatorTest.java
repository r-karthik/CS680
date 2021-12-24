package edu.umb.cs680.hw13;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Collections;
import java.util.LinkedList;
import org.junit.jupiter.api.Test;

class PriceComparatorTest {


    LinkedList<Car> carList = new LinkedList<Car>();

    @Test
    void test() {
        Car car1 = new Car("BMW", "X3", 2014, 23, 80000);
        Car car2 = new Car("Mercedes", "C300", 2013, 20, 95000);
        carList.add(car1);
        carList.add(car2);
        Collections.sort(carList, (Car arg0, Car arg1) -> (int) (arg1.getPrice() - arg0.getPrice()));
        assertEquals(car2, carList.get(0));
        assertEquals(car1, carList.get(1));

    }

}