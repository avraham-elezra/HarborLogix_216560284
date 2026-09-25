package harborlogix.app;

import harborlogix.cargo.*;
import harborlogix.clients.*;
import harborlogix.ops.*;

public class TerminalApp {

    public static void main(String[] args) {
        System.out.println("HarborLogix terminal - student " + TariffPolicy.STUDENT_ID);

        // --- הכנת נתונים ---
        Client stdClient = new Client("C-001", "Standard Imports");
        ContractClient conClient = new ContractClient("C-002", "Global Logistics", 15.0);
        GovernmentClient govClient = new GovernmentClient("C-003", "Ministry of Health", "MOH-IL");

        Yard yard = new Yard("Ashdod Terminal A", TariffPolicy.YARD_CAPACITY);

        StandardContainer std = new StandardContainer("U-01", stdClient, 2000, 5, 33.2);
        RefrigeratedContainer reefer = new RefrigeratedContainer("U-02", conClient, 3500, 3, 33.2, 4.0, 5.5);
        HazmatContainer haz = new HazmatContainer("U-03", govClient, 1500, 2, 33.2, 3, true);
        LiquidTank tank = new LiquidTank("U-04", conClient, 4000, 10, 25000, 80.0);

        yard.receive(std);
        yard.receive(reefer);
        yard.receive(haz);
        yard.receive(tank);


        System.out.println("\n=== 1. YARD MANIFEST ===");
        yard.printManifest();


        System.out.println("\n=== 2. CLIENT INVOICES ===");
        System.out.printf("Invoice for %s: %.2f NIS\n", stdClient.getName(), yard.invoiceFor(stdClient));
        System.out.printf("Invoice for %s (Discount: %.1f%%): %.2f NIS\n", conClient.getName(), conClient.discountPercent(), yard.invoiceFor(conClient));
        System.out.printf("Invoice for %s (Discount: %.1f%%): %.2f NIS\n", govClient.getName(), govClient.discountPercent(), yard.invoiceFor(govClient));


        System.out.println("\n=== 3. DRAINAGE ROUND ===");
        for (CargoUnit unit : yard.getUnits()) {
            if (unit instanceof LiquidTank tankUnit) {
                double pumped = tankUnit.transferOut(3000);
                System.out.printf("Drained %.2f liters from tank %s. New fill percent: %.1f%%\n",
                        pumped, tankUnit.getUnitId(), tankUnit.getFillPercent());
            }
        }


        System.out.println("\n=== 4. PART D - OVERSIZED CARGO ===");
        OversizedCargo bigCargo = new OversizedCargo("U-05", govClient, 12000, 1, 15.5, true);
        yard.receive(bigCargo);
        System.out.println("Oversized cargo added successfully. Reprinting manifest:\n");
        yard.printManifest();


        System.out.println("\n=== 5. BONUS - INSPECTION NOTES ===");
        yard.printInspectionNotes();
    }
}