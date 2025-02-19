//  ------------------------------------------------------------------------------
//  Assignment 1
//  Question: (include question/part number, if applicable)
//  Written by: Emile Ghattas (id: 40282552) and Zeidan Chabo (id:)
//  ------------------------------------------------------------------------------

package src.vehicle;

public class Car extends Vehicle {
    protected int maxPassengers;

    // Default Constructor
    public Car() {
        super();
        this.maxPassengers = 4;
    }

    // Parameterized Constructor
    public Car(String make, String model, int year, int maxPassengers) {
        super(make, model, year);
        this.maxPassengers = maxPassengers;
    }

    // Copy Constructor
    public Car(Car other) {
        super(other);
        this.maxPassengers = other.maxPassengers;
    }

    public void setMaxPassengers(int maxPassengers) {
        this.maxPassengers = maxPassengers;
    }

    public int getMaxPassengers() {
        return maxPassengers;
    }

    public boolean equals(Object obj) {
        if (obj == null || !super.equals(obj)) return false;
        Car car = (Car) obj;
        return maxPassengers == car.maxPassengers;
    }

    public String toString() {
        return super.toString() + ", Max Passengers: " + maxPassengers;
    }
}
