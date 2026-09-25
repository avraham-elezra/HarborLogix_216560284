package harborlogix.ops;

import harborlogix.cargo.CargoUnit;
import harborlogix.cargo.Inspectable;
import harborlogix.clients.Client;
import java.util.ArrayList;

public class Yard {

    private final String yardName;
    private final int capacity;
    private final ArrayList<CargoUnit> units = new ArrayList<>();

    public Yard(String yardName, int capacity) {
        if (yardName == null || yardName.trim().isEmpty()) {
            throw new IllegalArgumentException("Yard name cannot be null or empty");
        }
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        this.yardName = yardName;
        this.capacity = capacity;
    }

    public String getYardName() { return yardName; }
    public int getCapacity()    { return capacity; }
    public int getUnitCount()   { return units.size(); }

    public ArrayList<CargoUnit> getUnits() {
        return new ArrayList<>(units);
    }

    public void receive(CargoUnit unit) {
        if (unit == null) {
            throw new IllegalArgumentException("Cannot receive null unit");
        }
        if (units.size() >= capacity) {
            throw new IllegalStateException("Yard is at full capacity");
        }
        for (CargoUnit existing : units) {
            if (existing.getUnitId().equals(unit.getUnitId())) {
                throw new IllegalArgumentException("Unit ID already exists: " + unit.getUnitId());
            }
        }
        units.add(unit);
    }

    public double totalDailyRevenue() {
        double total = 0;
        for (CargoUnit unit : units) {
            total += unit.dailyStorageFee();
        }
        return total;
    }

    public double invoiceFor(Client client) {
        if (client == null) {
            throw new IllegalArgumentException("Client cannot be null");
        }
        double total = 0;
        for (CargoUnit unit : units) {
            if (unit.getOwner().getClientId().equals(client.getClientId())) {
                total += unit.totalStorageCharge();
            }
        }
        double discountMultiplier = 1.0 - (client.discountPercent() / 100.0);
        return total * discountMultiplier;
    }

    public CargoUnit heaviestUnit() {
        if (units.isEmpty()) {
            return null;
        }
        CargoUnit heaviest = units.get(0);
        for (CargoUnit unit : units) {
            if (unit.getWeightKg() > heaviest.getWeightKg()) {
                heaviest = unit;
            }
        }
        return heaviest;
    }

    public void printManifest() {
        for (CargoUnit unit : units) {
            System.out.println(unit.toString());
            System.out.println("Safety: " + unit.safetyBriefing());
        }
        System.out.printf("Total Daily Revenue: %.2f\n", totalDailyRevenue());
    }

    public void printInspectionNotes() {
        for (CargoUnit unit : units) {
            if (Inspectable.class.isInstance(unit)) {
                Inspectable item = (Inspectable) unit;
                System.out.println("Inspection for " + unit.getUnitId() + ": " + item.inspectionNote());
            }
        }
    }
}