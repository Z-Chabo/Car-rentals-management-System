package src.vehicle;

public class ElectricCar extends Car {
    private int maxAutonomy;
    private static int ecCount = 1001;

    // Default Constructor
    public ElectricCar() {
        super();
        this.maxAutonomy = 300;
        this.plateNumber = generatePlateNumber();
    }

    // Parameterized Constructor
    public ElectricCar(String make, String model, int year, int maxPassengers, int maxAutonomy) {
        super(make, model, year, maxPassengers);
        this.maxAutonomy = maxAutonomy;
        this.plateNumber = generatePlateNumber();
    }

    // Copy Constructor
    public ElectricCar(ElectricCar other) {
        super(other);
        this.maxAutonomy = other.maxAutonomy;
        this.plateNumber = generatePlateNumber();
    }

    public void setMaxAutonomy(int maxAutonomy) {
        this.maxAutonomy = maxAutonomy;
    }

    public int getMaxAutonomy() {
        return maxAutonomy;
    }

    private String generatePlateNumber() {
        return "EC" + ecCount++;
    }

    public boolean equals(Object obj) {
        if (obj == null || !super.equals(obj)) return false;
        ElectricCar ec = (ElectricCar) obj;
        return maxAutonomy == ec.maxAutonomy;
    }

    public String toString() {
        return super.toString() + ", Max Autonomy: " + maxAutonomy + " km";
    }
}
