package harborlogix.cargo;

import harborlogix.clients.Client;
import harborlogix.ops.TariffPolicy;

public class RefrigeratedContainer extends StandardContainer implements Inspectable {

    private final double targetTempC;
    private final double powerDrawKw;

    public RefrigeratedContainer(String unitId, Client owner, double weightKg,
                                 int daysStored, double volumeM3,
                                 double targetTempC, double powerDrawKw) {
        super(unitId, owner, weightKg, daysStored, volumeM3);
        if (targetTempC > 8.0) {
            throw new IllegalArgumentException();
        }
        if (powerDrawKw <= 0) {
            throw new IllegalArgumentException();
        }
        this.targetTempC = targetTempC;
        this.powerDrawKw = powerDrawKw;
    }

    public double getTargetTempC() {
        return targetTempC;
    }

    public double getPowerDrawKw() {
        return powerDrawKw;
    }

    @Override
    public double dailyStorageFee() {
        return super.dailyStorageFee() + (TariffPolicy.POWER_RATE * powerDrawKw);
    }

    @Override
    public String handlingCategory() {
        return "Reefer";
    }

    @Override
    public String safetyBriefing() {
        return String.format("Maintain target temp: %.1fC", targetTempC);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" [temp=%.1fC, power=%.1fkW]", targetTempC, powerDrawKw);
    }

    @Override
    public String inspectionNote() {
        return "Check compressor and power cable integrity.";
    }
}