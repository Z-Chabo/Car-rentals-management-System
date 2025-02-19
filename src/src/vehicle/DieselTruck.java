package src.vehicle;

public class DieselTruck extends Truck {
    private int fuelTankCapacity;
    private static int dtCount = 1001;

    // Default Constructor
    public DieselTruck() {
        super();
        this.fuelTankCapacity = 50;
        this.plateNumber = generatePlateNumber();
    }

    // Parameterized Constructor
    public DieselTruck(String make, String model, int year, int maxCapacity, int fuelTankCapacity) {
        super(make, model, year, maxCapacity);
        this.fuelTankCapacity = fuelTankCapacity;
        this.plateNumber = generatePlateNumber();
    }

    // Copy Constructor
    public DieselTruck(DieselTruck other) {
        super(other);
        this.fuelTankCapacity = other.fuelTankCapacity;
        this.plateNumber = generatePlateNumber();
    }

    public void setFuelTankCapacity(int fuelTankCapacity) {
        this.fuelTankCapacity = fuelTankCapacity;
    }

    public int getFuelTankCapacity() {
        return fuelTankCapacity;
    }

    private String generatePlateNumber() {
        return "DT" + dtCount++;
    }

    public boolean equals(Object obj) {
        if (obj == null || !super.equals(obj)) return false;
        DieselTruck dt = (DieselTruck) obj;
        return fuelTankCapacity == dt.fuelTankCapacity;
    }

    public String toString() {
        return super.toString() + ", Fuel Tank: " + fuelTankCapacity + " L";
    }

    // Method to get the truck with the largest capacity
    public static DieselTruck getLargestTruck(DieselTruck[] trucks) {
        if (trucks == null || trucks.length == 0) return null;
        DieselTruck largest = trucks[0];
        for (DieselTruck truck : trucks) {
            if (truck != null && truck.maxCapacity > largest.maxCapacity) {
                largest = truck;
            }
        }
        return largest;
    }
}
