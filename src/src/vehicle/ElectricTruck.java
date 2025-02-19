package src.vehicle;

public class ElectricTruck extends Truck {
    private int maxAutonomy;
    private static int etCount = 1001;

    // Default Constructor
    public ElectricTruck() {
        super();
        this.maxAutonomy = 200;
        this.plateNumber = generatePlateNumber();
    }

    // Parameterized Constructor
    public ElectricTruck(String make, String model, int year, int maxCapacity, int maxAutonomy) {
        super(make, model, year, maxCapacity);
        this.maxAutonomy = maxAutonomy;
        this.plateNumber = generatePlateNumber();
    }

    // Copy Constructor
    public ElectricTruck(ElectricTruck other) {
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
        return "ET" + etCount++;
    }

    public boolean equals(Object obj) {
        if (obj == null || !super.equals(obj)) return false;
        ElectricTruck et = (ElectricTruck) obj;
        return maxAutonomy == et.maxAutonomy;
    }

    public String toString() {
        return super.toString() + ", Max Autonomy: " + maxAutonomy + " km";
    }

    // Method to create a deep copy of the array of electric trucks
    public static ElectricTruck[] copyVehicles(ElectricTruck[] trucks) {
        if (trucks == null) return null;
        ElectricTruck[] copy = new ElectricTruck[trucks.length];
        for (int i = 0; i < trucks.length; i++) {
            if (trucks[i] == null) continue;
            if (trucks[i] != null) {
                copy[i] = new ElectricTruck(trucks[i]);
            }
        }
        return copy;
    }
}
