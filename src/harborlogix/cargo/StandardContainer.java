package harborlogix.cargo;

import harborlogix.clients.Client;
import harborlogix.ops.TariffPolicy;

/**
 * SKELETON.  StandardContainer IS-A CargoUnit.
 *
 * Extra state : volumeM3 (must be positive)
 * Daily fee   : BASE_STORAGE_RATE * volumeM3
 * Category    : "Standard"
 * Briefing    : any sensible one-line message
 */
public class StandardContainer extends CargoUnit {

    // TODO: private final double volumeM3;

    public StandardContainer(String unitId, Client owner, double weightKg,
                             int daysStored, double volumeM3) {
        super(unitId, owner, weightKg, daysStored);
        // TODO: validate volumeM3 > 0, then assign
        throw new UnsupportedOperationException("TODO StandardContainer constructor");
    }

    public double getVolumeM3() {
        throw new UnsupportedOperationException("TODO getVolumeM3");
    }

    @Override
    public double dailyStorageFee() {
        throw new UnsupportedOperationException("TODO dailyStorageFee");
    }

    @Override
    public String handlingCategory() {
        throw new UnsupportedOperationException("TODO handlingCategory");
    }

    @Override
    public String safetyBriefing() {
        throw new UnsupportedOperationException("TODO safetyBriefing");
    }

    // TODO: override toString(), reusing super.toString()
}
