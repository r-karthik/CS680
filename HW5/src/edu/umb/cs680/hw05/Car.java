package edu.umb.cs680.hw05;

public class Car {

    private String make, model;
    private int mileage, year;
    private float price;

    // Constructor
    public Car(String make, String model , int mileage, int year, float price) {
        this.make=make;
        this.model=model;
        this.year=year;
        this.mileage=mileage;
        this.price=price;

    }

    // Getter Methods
    public String getMake() {
        return this.make;
    }

    public String getModel() {
        return  this.model;
    }

    public int getMileage() {
        return this.mileage;
    }

    public int getYear() {
        return this.year;
    }

    public float getPrice() {
        return this.price;
    }

    public static void main(String[] args) {
        Car c = new Car("Tata", "nano", 24, 2014, 9 );
    }

}
