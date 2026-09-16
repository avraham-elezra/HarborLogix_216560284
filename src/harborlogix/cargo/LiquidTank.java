package harborlogix.cargo;

import harborlogix.clients.Client;
import harborlogix.ops.TariffPolicy;

/**
 * SKELETON.  A DIRECT child of CargoUnit - a separate branch from the
 * container family. Do not make it extend StandardContainer.
 *
 * Extra state : capacityLitres (positive), fillPercent (0-100, mutable)
 * currentLitres() : capacityLitres * fillPercent / 100
 * Daily fee   : LIQUID_RATE * currentLitres()   (actual content, not capacity)
 * Category    : "Tank"
 *
 * transferOut() exists ONLY here. It is the method you will use in Part C
 * to demonstrate the one downcast this assignment permits.
 */
public class LiquidTank extends CargoUnit {

    // TODO: private final double capacityLitres;  private double fillPercent;

    public LiquidTank(String unitId, Client owner, double weightKg,
                      int daysStored, double capacityLitres, double fillPercent) {
        super(unitId, owner, weightKg, daysStored);
        // TODO: validate and assign
        throw new UnsupportedOperationException("TODO LiquidTank constructor");
    }

    public double getCapacityLitres() {
        throw new UnsupportedOperationException("TODO getCapacityLitres");
    }

    public double getFillPercent() {
        throw new UnsupportedOperationException("TODO getFillPercent");
    }

    public double currentLitres() {
        throw new UnsupportedOperationException("TODO currentLitres");
    }

    /**
     * Pumps out up to `litres` and returns how much was actually moved
     * (never more than is present). Updates fillPercent accordingly.
     * Reject a non-positive request with IllegalArgumentException.
     */
    public double transferOut(double litres) {
        throw new UnsupportedOperationException("TODO transferOut");
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
