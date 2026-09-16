package harborlogix.cargo;

import harborlogix.clients.Client;
import harborlogix.ops.TariffPolicy;

/**
 * SKELETON.  Also a child of StandardContainer - a sibling of the reefer.
 *
 * Extra state : hazardClass (1-9 only), requiresEscort (boolean)
 * Daily fee   : the parent's fee MULTIPLIED by HAZMAT_MULTIPLIER
 * Category    : "Hazmat"
 * Briefing    : must state the hazard class number
 */
public class HazmatContainer extends StandardContainer {

    // TODO: private final fields

    public HazmatContainer(String unitId, Client owner, double weightKg,
                           int daysStored, double volumeM3,
                           int hazardClass, boolean requiresEscort) {
        super(unitId, owner, weightKg, daysStored, volumeM3);
        // TODO: validate and assign
        throw new UnsupportedOperationException("TODO HazmatContainer constructor");
    }

    public int getHazardClass() {
        throw new UnsupportedOperationException("TODO getHazardClass");
    }

    public boolean isRequiresEscort() {
        throw new UnsupportedOperationException("TODO isRequiresEscort");
    }

    // TODO: override dailyStorageFee(), handlingCategory(), safetyBriefing(), toString()
}
