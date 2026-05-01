public class Car {
    String plateNumber;
    String color;

    Car(String plateNumber, String color) {
        this.plateNumber = plateNumber;
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        return plateNumber.equals(((Car)o).plateNumber);
    }

    @Override
    public int hashCode() {
        return plateNumber.hashCode();
    }
}
