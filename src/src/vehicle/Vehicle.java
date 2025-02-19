package src.vehicle;

public class Vehicle {
    protected String plateNumber;
    protected String make;
    protected String model;
    protected int year;


    // Default Constructor
    public Vehicle() {
        this.make = "Unknown";
        this.model = "Unknown";
        this.year = 2000;
        this.plateNumber = "Unknown";
    }

    // Parameterized Constructor
    public Vehicle(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;

    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public int getYear() {
        return year;
    }

    public String getModel() {
        return model;
    }

    // Copy Constructor
    public Vehicle(Vehicle other) {
        this.make = other.make;
        this.model = other.model;
        this.year = other.year;

    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Vehicle vehicle = (Vehicle) obj;
        return year == vehicle.year && make.equals(vehicle.make) && model.equals(vehicle.model);
    }

    public String toString() {
        return "Plate: " + plateNumber + ", Make: " + make + ", Model: " + model + ", Year: " + year;
    }

    // Getter for Plate Number
    public String getPlateNumber() {
        return this.plateNumber;
    }

    // Static method to add a vehicle to an array (or collection in the future)
    public static void addVehicle(Vehicle v) {
        System.out.println("Vehicle added: " + v);
    }

}


