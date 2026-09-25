package harborlogix.cargo;

import harborlogix.clients.Client;
import harborlogix.ops.TariffPolicy;

public class OversizedCargo extends CargoUnit {

    private final double length;
    private final boolean needsHeavyCrane;

    public OversizedCargo(String unitId, Client owner, double weightKg,
                          int daysStored, double length, boolean needsHeavyCrane) {
        super(unitId, owner, weightKg, daysStored);
        if (length <= 1.0) {
            throw new IllegalArgumentException("Length must be greater than 1.0 meter");
        }
        this.length = length;
        this.needsHeavyCrane = needsHeavyCrane;
    }

    public double getLength() {
        return length;
    }

    public boolean isNeedsHeavyCrane() {
        return needsHeavyCrane;
    }

    @Override
    public double dailyStorageFee() {
        return TariffPolicy.OVERSIZE_DAILY_FLAT + (length * 5.0);
    }

    @Override
    public String handlingCategory() {
        return "Oversize";
    }

    @Override
    public String safetyBriefing() {
        return "Heavy crane required: " + needsHeavyCrane;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" [length=%.1fm, crane=%b]", length, needsHeavyCrane);
    }
}