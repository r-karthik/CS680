package edu.umb.cs680.hw11;

import java.util.ArrayList;
import java.util.Collections;

public class SortTest {

    public static void main(String[] args) {
        ArrayList<Car> car = new ArrayList<Car>();
        car.add(new Car("Mustang",2018, 28000, 2600f));
        car.add(new Car("XUV500", 2014, 5000, 7100f));
        car.add(new Car("mercedes Aclass", 2017, 15000, 7500f));
        car.add(new Car("Porsche",2019,14000,8900f));
        car.add(new Car("BMW d",2011,10000,1100f));
        System.out.println("Name | Year |  Mileage | Price");
        for(Car c: car){
            System.out.println("Before use of function ");
            System.out.println(c+" | "+c.getYear()+" | "+c.getPrice()+" | "+c.getMileage());
        }
        System.out.println("Worked function results");

        Collections.sort(car, new MileageComparator());
        System.out.println("Mileage: "+car);

        Collections.sort(car, new YearComparator());
        System.out.println("Year: "+car);

        Collections.sort(car, new PriceComparator());
        System.out.println("Price: "+car);

        Collections.sort(car, new ParetoComparator(car));
        System.out.println("Pareto: "+car);

    }


}