package src.vehicle;

public class GasolineCar extends Car {
    private static int gcCount = 1001;

    // Default Constructor
    public GasolineCar() {
        super();
        this.plateNumber = generatePlateNumber();
    }

    // Parameterized Constructor
    public GasolineCar(String make, String model, int year, int maxPassengers) {
        super(make, model, year, maxPassengers);
        this.plateNumber = generatePlateNumber();
    }

    // Copy Constructor
    public GasolineCar(GasolineCar other) {
        super(other);
        this.plateNumber = generatePlateNumber();
    }

    private String generatePlateNumber() {
        return "GC" + gcCount++;
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public String toString() {
        return super.toString();
    }
}
