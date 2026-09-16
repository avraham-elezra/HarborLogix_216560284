package harborlogix.app;

import harborlogix.cargo.*;
import harborlogix.clients.*;
import harborlogix.ops.*;

/**
 * SKELETON - your demonstration program.
 *
 * It must print, in this order, with clear section headings:
 *
 *   1. A yard manifest holding AT LEAST one of every cargo type.
 *   2. Invoices for all three client tiers, showing the discount applied.
 *   3. The drainage round - the one place a downcast is permitted.
 *      Use pattern matching: `if (unit instanceof LiquidTank tank)`.
 *   4. Part D: receive an OversizedCargo into the SAME yard object and
 *      reprint the manifest, proving Yard needed no changes.
 *
 * Build the yard with capacity TariffPolicy.YARD_CAPACITY.
 */
public class TerminalApp {

    public static void main(String[] args) {
        System.out.println("HarborLogix terminal - student " + TariffPolicy.STUDENT_ID);
        // TODO: sections 1-4
    }
}
