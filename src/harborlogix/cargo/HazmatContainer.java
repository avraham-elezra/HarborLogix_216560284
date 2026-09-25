package harborlogix.cargo;

import harborlogix.clients.Client;
import harborlogix.ops.TariffPolicy;

public class HazmatContainer extends StandardContainer implements Inspectable {

    private final int hazardClass;
    private final boolean requiresEscort;

    public HazmatContainer(String unitId, Client owner, double weightKg,
                           int daysStored, double volumeM3,
                           int hazardClass, boolean requiresEscort) {
        super(unitId, owner, weightKg, daysStored, volumeM3);
        if (hazardClass < 1 || hazardClass > 9) {
            throw new IllegalArgumentException();
        }
        this.hazardClass = hazardClass;
        this.requiresEscort = requiresEscort;
    }

    public int getHazardClass() {
        return hazardClass;
    }

    public boolean isRequiresEscort() {
        return requiresEscort;
    }

    @Override
    public double dailyStorageFee() {
        return super.dailyStorageFee() * TariffPolicy.HAZMAT_MULTIPLIER;
    }

    @Override
    public String handlingCategory() {
        return "Hazmat";
    }

    @Override
    public String safetyBriefing() {
        return String.format("Hazard Class %d. Escort required: %b", hazardClass, requiresEscort);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" [Hazard Class=%d, Escort=%b]", hazardClass, requiresEscort);
    }

    @Override
    public String inspectionNote() {
        return "Verify hazmat placards are visible and seals are intact.";
    }
}