package com.practice.problem2.evaluator;

import com.practice.problem2.models.*;
import com.practice.problem2.services.*;
import com.practice.problem2.exceptions.*;

/**
 * 🔒 LOCKED -- Students must not edit this file!
 *
 * Evaluates implementations for Parking Lot Manager.
 * Run via Main.java.
 */
public class Evaluator {
    public static void run() {
        int passed = 0;
        int total = 22;

        try {
            ParkingLotService service = new ParkingLotService(3);

            // 1. Add vehicle
            Vehicle v1 = new Vehicle("ABC123", "Car");
            service.parkVehicle(v1);
            passed++;

            // 2. Park another
            Vehicle v2 = new Vehicle("XYZ789", "Bike");
            service.parkVehicle(v2);
            passed++;

            // 3. Park same vehicle throws
            try {
                service.parkVehicle(v1);
                throw new RuntimeException("Duplicate vehicle not detected");
            } catch (SlotNotAvailableException ex) {
                passed++;
            }

            // 4. Remove vehicle
            service.removeVehicle("ABC123");
            passed++;

            // 5. Remove non-existent vehicle throws
            try {
                service.removeVehicle("UNKNOWN");
                throw new RuntimeException("Missing vehicle not detected");
            } catch (VehicleNotFoundException ex) {
                passed++;
            }

            // 6. Park after removal
            service.parkVehicle(new Vehicle("ABC123", "Car"));
            passed++;

            // 7. Fill lot
            service.parkVehicle(new Vehicle("DEF456", "Truck"));
            passed++;

            // 8. Lot full throws
            try {
                service.parkVehicle(new Vehicle("GHJ890", "Bus"));
                throw new RuntimeException("Lot overflow not detected");
            } catch (ParkingLotFullException ex) {
                passed++;
            }

            // 9. Slots availability
            for (int i = 0; i < 3; i++) {
                Slot slot = service.getSlot(i);
                if (slot == null) throw new RuntimeException("No slot returned");
            }
            passed++;

            // 10. Capacity boundary
            try {
                Slot slot = service.getSlot(3);
                throw new RuntimeException("Invalid slot index not detected");
            } catch (RuntimeException ex) {
                passed++;
            }

            // 11. Null vehicle park throws
            try {
                service.parkVehicle(null);
                throw new RuntimeException("Null vehicle not detected");
            } catch (NullPointerException ex) {
                passed++;
            }

            // 12. Null remove throws
            try {
                service.removeVehicle(null);
                throw new RuntimeException("Null vehicleId not detected");
            } catch (NullPointerException ex) {
                passed++;
            }

            // 13. Park/Remove repeatedly
            for (int i = 0; i < 3; i++) {
                Vehicle v = new Vehicle("REP" + i, "Car");
                service.parkVehicle(v);
                service.removeVehicle("REP" + i);
            }
            passed++;

            // 14. Defensive: remove again throws
            try {
                service.removeVehicle("REP0");
                throw new RuntimeException("Repeated remove not detected");
            } catch (VehicleNotFoundException ex) {
                passed++;
            }

            // 15. Slot properties
            Slot s = new Slot(0);
            if (s.getSlotNumber() != 0) throw new RuntimeException("Wrong slot number");
            passed++;

            // 16. Parkable interface
            if (!v1.getClass().getInterfaces()[0].getSimpleName().equals("Parkable")) throw new RuntimeException("Interface missing");
            passed++;

            // 17. Parking lot state after removal
            service.removeVehicle("DEF456");
            if (service.isFull()) throw new RuntimeException("Full state wrong after removal");
            passed++;

            // 18. Park lots at max boundary
            Vehicle[] bulk = { new Vehicle("A1", "Car"), new Vehicle("A2", "Car"), new Vehicle("A3", "Car") };
            ParkingLotService lot = new ParkingLotService(3);
            for (Vehicle v : bulk) lot.parkVehicle(v);
            if (!lot.isFull()) throw new RuntimeException("Full state wrong");
            passed++;

            // 19. Re-park after removal
            lot.removeVehicle("A2");
            lot.parkVehicle(new Vehicle("A4", "Car"));
            passed++;

            // 20. Defensive: slot negative
            try {
                Slot ns = new Slot(-1);
                throw new RuntimeException("Negative slot not detected");
            } catch (RuntimeException ex) {
                passed++;
            }

            // 21. Defensive: null slot
            try {
                lot.getSlot(-1);
                throw new RuntimeException("Negative slot index not detected");
            } catch (RuntimeException ex) {
                passed++;
            }

            // 22. Parkable mark
            Parkable pv = new Vehicle("ZZZ", "Truck");
            pv.park();
            pv.unpark();
            passed++;

            System.out.println("ALL TESTS PASSED");
        } catch (RuntimeException ex) {
            System.out.println("FAILED TESTS: " + (total - passed) + " / " + total);
            throw ex;
        }
    }
}