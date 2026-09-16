package harborlogix.cargo;

import harborlogix.clients.Client;
import harborlogix.ops.TariffPolicy;

/**
 * SKELETON.  Level 3 of the hierarchy.
 *
 * Extra state : targetTempC (must be 8.0 or below), powerDrawKw (positive)
 * Daily fee   : the parent's fee PLUS (POWER_RATE * powerDrawKw)
 *               You must EXTEND the parent's fee, not recompute it.
 * Category    : "Reefer"
 */
public class RefrigeratedContainer extends StandardContainer {

    // TODO: private final fields

    public RefrigeratedContainer(String unitId, Client owner, double weightKg,
                                 int daysStored, double volumeM3,
                                 double targetTempC, double powerDrawKw) {
        super(unitId, owner, weightKg, daysStored, volumeM3);
        // TODO: validate and assign
        throw new UnsupportedOperationException("TODO RefrigeratedContainer constructor");
    }

    public double getTargetTempC() {
        throw new UnsupportedOperationException("TODO getTargetTempC");
    }

    public double getPowerDrawKw() {
        throw new UnsupportedOperationException("TODO getPowerDrawKw");
    }

    // TODO: override dailyStorageFee() using super.dailyStorageFee()
    // TODO: override handlingCategory(), safetyBriefing(), toString()
}
