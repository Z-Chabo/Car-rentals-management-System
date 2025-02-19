//  ------------------------------------------------------------------------------
//  Assignment 1
//  Question: (include question/part number, if applicable)
//  Written by: Emile Ghattas (id: 40282552) and Zeidan Chabo (id:)
//  ------------------------------------------------------------------------------

package src.vehicle;

public class Truck extends Vehicle {
    protected int maxCapacity;

    // Default Constructor
    public Truck() {
        super();
        this.maxCapacity = 1000;
    }

    // Parameterized Constructor
    public Truck(String make, String model, int year, int maxCapacity) {
        super(make, model, year);
        this.maxCapacity = maxCapacity;

    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    // Copy Constructor
    public Truck(Truck other) {
        super(other);
        this.maxCapacity = other.maxCapacity;
    }

    public boolean equals(Object obj) {
        if (obj == null || !super.equals(obj)) return false;
        Truck truck = (Truck) obj;
        return maxCapacity == truck.maxCapacity;
    }

    public String toString() {
        return super.toString() + ", Max Capacity: " + maxCapacity + " kg";
    }
}
