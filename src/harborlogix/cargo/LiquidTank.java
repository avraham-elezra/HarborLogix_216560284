package harborlogix.cargo;

import harborlogix.clients.Client;
import harborlogix.ops.TariffPolicy;

public class LiquidTank extends CargoUnit {

    private final double capacityLitres;
    private double fillPercent;

    public LiquidTank(String unitId, Client owner, double weightKg,
                      int daysStored, double capacityLitres, double fillPercent) {
        super(unitId, owner, weightKg, daysStored);
        if (capacityLitres <= 0) {
            throw new IllegalArgumentException();
        }
        if (fillPercent < 0 || fillPercent > 100) {
            throw new IllegalArgumentException();
        }
        this.capacityLitres = capacityLitres;
        this.fillPercent = fillPercent;
    }

    public double getCapacityLitres() {
        return capacityLitres;
    }

    public double getFillPercent() {
        return fillPercent;
    }

    public double currentLitres() {
        return capacityLitres * (fillPercent / 100.0);
    }

    public double transferOut(double litres) {
        if (litres <= 0) {
            throw new IllegalArgumentException();
        }
        double current = currentLitres();
        double moved = Math.min(litres, current);
        double newLitres = current - moved;
        this.fillPercent = (newLitres / capacityLitres) * 100.0;
        return moved;
    }

    @Override
    public double dailyStorageFee() {
        return TariffPolicy.LIQUID_RATE * currentLitres();
    }

    @Override
    public String handlingCategory() {
        return "Tank";
    }

    @Override
    public String safetyBriefing() {
        return "Liquid Tank Handling Protocol.";
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" [Capacity=%.1fL, Fill=%.1f%%]", capacityLitres, fillPercent);
    }
}