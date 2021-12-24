package edu.umb.cs680.hw11;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CarTest {

    ArrayList<Car> usedCars = new ArrayList<Car>();

    @Test
    public void MileageComparatorTest() {
        ArrayList<Float> actual = new ArrayList<>();
        ArrayList<Float> expected = new ArrayList<>();
        usedCars.add(new Car("Ford(A)",2010, 10000, 5200f));
        usedCars.add(new Car("Suzuki(B)", 2011, 9000, 6100f));
        usedCars.add(new Car("Ferrari(C)", 2012, 15000, 8100f));
        usedCars.add(new Car("Benz(E)",2014,9000,6500f));

        Collections.sort(usedCars, new MileageComparator());
        for(Car c : usedCars){
            actual.add(c.getMileage());
        }

        expected.add(8100f);
        expected.add(6500f);
        expected.add(6100f);
        expected.add(5200f);
        assertEquals(actual, expected);
    }

    @Test
    public void PriceComparatorTest(){
        ArrayList<Integer> actual = new ArrayList<>();
        ArrayList<Integer> expected = new ArrayList<>();
        usedCars.add(new Car("Ford(A)",2010, 10000, 5200f));
        usedCars.add(new Car("Suzuki(B)", 2011, 9000, 6100f));
        usedCars.add(new Car("Ferrari(C)", 2012, 15000, 8100f));
        usedCars.add(new Car("Benz(E)",2014,9000,6500f));

        Collections.sort(usedCars, new PriceComparator());
        for(Car c : usedCars){
            actual.add(c.getPrice());
        }
        expected.add(15000);
        expected.add(10000);
        expected.add(9000);
        expected.add(9000);
        assertEquals(actual, expected);
    }

    @Test
    public void YearComparatorTest(){
        ArrayList<Integer> actual = new ArrayList<>();
        ArrayList<Integer> expected = new ArrayList<>();
        usedCars.add(new Car("Ford(A)",2010, 10000, 5200f));
        usedCars.add(new Car("Suzuki(B)", 2011, 9000, 6100f));
        usedCars.add(new Car("Ferrari(C)", 2012, 15000, 8100f));
        usedCars.add(new Car("Benz(E)",2014,9000,6500f));

        Collections.sort(usedCars, new YearComparator());
        for(Car c : usedCars){
            actual.add(c.getYear());
        }
        expected.add(2010);
        expected.add(2011);
        expected.add(2012);
        expected.add(2014);
        assertEquals(actual, expected);
    }

    @Test
    public void DominationComparatorTest() {

        Car car1 = new Car("Ford(A)",2010, 10000, 5200f);
        Car car2 = new Car("Suzuki(B)", 2011, 9000, 6100f);
        Car car3 = new Car("Ferrari(C)", 2012, 15000, 8100f);
        Car car4 = new Car("Benz(E)",2014,9000,6500f);

        ArrayList<Car> carList = new ArrayList<Car>();

        carList.add(car1);
        carList.add(car2);
        carList.add(car3);
        car4.dominationCount(carList, car4);
        carList.clear();

        carList.add(car2);
        carList.add(car3);
        carList.add(car4);
        car1.dominationCount(carList, car1);
        carList.clear();

        carList.add(car4);
        carList.add(car1);
        carList.add(car3);
        car2.dominationCount(carList, car2);
        carList.clear();

        carList.add(car4);
        carList.add(car1);
        carList.add(car2);
        car3.dominationCount(carList, car3);

        ArrayList<Car> carListToSort = new ArrayList<Car>();
        carListToSort.add(car1);
        carListToSort.add(car2);
        carListToSort.add(car3);
        carListToSort.add(car4);
    }
}