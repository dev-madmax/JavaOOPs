package com.practice.problem10.evaluator;

import com.practice.problem10.services.*;
import com.practice.problem10.models.*;
import com.practice.problem10.exceptions.*;

/**
 * 🔒 LOCKED -- Students must not edit this file!
 *
 * Evaluates implementations for Restaurant Table Reservation System.
 * Run via Main.java.
 */
public class Evaluator {
    public static void run() {
        int passed = 0;
        int total = 24;

        try {
            ReservationService service = new ReservationService();

            // 1. Add customer
            Customer c1 = new Customer(1, "Alice");
            service.addCustomer(c1);
            passed++;

            // 2. Add another customer
            Customer c2 = new Customer(2, "Bob");
            service.addCustomer(c2);
            passed++;

            // 3. Duplicate customer throws
            try {
                service.addCustomer(new Customer(1, "SomeoneElse"));
                throw new RuntimeException("Duplicate customer not detected");
            } catch (RuntimeException ex) {
                passed++;
            }

            // 4. Add table
            Table t1 = new Table(101, 2);
            service.addTable(t1);
            passed++;

            // 5. Add another table
            Table t2 = new Table(102, 4);
            service.addTable(t2);
            passed++;

            // 6. Duplicate table throws
            try {
                service.addTable(new Table(101, 6));
                throw new RuntimeException("Duplicate table not detected");
            } catch (RuntimeException ex) {
                passed++;
            }

            // 7. Reserve table for Alice
            Reservation r1 = service.reserveTable(1, 101, "2024-04-01", "19:00");
            passed++;

            // 8. Table status reserved
            if (!service.isTableReserved(101, "2024-04-01", "19:00")) throw new RuntimeException("Table state not set");
            passed++;

            // 9. Reserve same table for Bob throws TableNotAvailableException
            try {
                service.reserveTable(2, 101, "2024-04-01", "19:00");
                throw new RuntimeException("Unavailable table reservation not detected");
            } catch (TableNotAvailableException ex) {
                passed++;
            }

            // 10. Reserve with non-existent customer
            try {
                service.reserveTable(99, 102, "2024-04-10", "18:00");
                throw new RuntimeException("Non-existent customer not detected");
            } catch (CustomerNotFoundException ex) {
                passed++;
            }

            // 11. Reserve non-existent table
            try {
                service.reserveTable(1, 999, "2024-04-10", "20:00");
                throw new RuntimeException("Non-existent table not detected");
            } catch (TableNotAvailableException ex) {
                passed++;
            }

            // 12. Cancel reservation
            service.cancelReservation(r1.getReservationId());
            if (service.isTableReserved(101, "2024-04-01", "19:00")) throw new RuntimeException("Table not released");
            passed++;

            // 13. Cancel reservation not found
            try {
                service.cancelReservation("FAKEID");
                throw new RuntimeException("Cancel of not found reservation not detected");
            } catch (InvalidReservationException ex) {
                passed++;
            }

            // 14. Reserve after cancel
            Reservation r2 = service.reserveTable(2, 101, "2024-04-01", "19:00");
            if (!service.isTableReserved(101, "2024-04-01", "19:00")) throw new RuntimeException("Reservation after cancel failed");
            passed++;

            // 15. Null table handling
            try {
                service.addTable(null);
                throw new RuntimeException("Null table not detected");
            } catch (NullPointerException ex) {
                passed++;
            }

            // 16. Null customer handling
            try {
                service.addCustomer(null);
                throw new RuntimeException("Null customer not detected");
            } catch (NullPointerException ex) {
                passed++;
            }

            // 17. Reserve nulls
            try {
                service.reserveTable(1, 101, null, "19:00");
                throw new RuntimeException("Null date not detected");
            } catch (NullPointerException ex) {
                passed++;
            }

            // 18. Cancel null reservation id
            try {
                service.cancelReservation(null);
                throw new RuntimeException("Null reservation id not detected");
            } catch (NullPointerException ex) {
                passed++;
            }

            // 19. Remove customer
            service.removeCustomer(2);
            try {
                service.reserveTable(2, 102, "2024-04-10", "20:00");
                throw new RuntimeException("Reservation for removed customer allowed");
            } catch (CustomerNotFoundException ex) {
                passed++;
            }

            // 20. Remove table
            service.removeTable(102);
            try {
                service.reserveTable(1, 102, "2024-04-10", "20:00");
                throw new RuntimeException("Reservation for removed table allowed");
            } catch (TableNotAvailableException ex) {
                passed++;
            }

            // 21. Capacity: add many tables/customers/reservations
            for (int i = 200; i < 210; i++) {
                service.addTable(new Table(i, 4));
                service.addCustomer(new Customer(i, "Customer"+i));
                service.reserveTable(i, i, "2024-06-01", "20:00");
            }
            passed++;

            // 22. Defensive: table boundaries
            try {
                service.addTable(new Table(-1, 8));
                throw new RuntimeException("Negative table number not detected");
            } catch (RuntimeException ex) {
                passed++;
            }

            // 23. Defensive: customer boundaries
            try {
                service.addCustomer(new Customer(-1, "Invalid"));
                throw new RuntimeException("Negative customer id not detected");
            } catch (RuntimeException ex) {
                passed++;
            }

            // 24. Reservable interface check
            Reservable t = new Table(203, 2);
            t.reserve("2024-04-01", "19:00");
            t.unreserve();
            passed++;

            System.out.println("ALL TESTS PASSED");
        } catch (RuntimeException ex) {
            System.out.println("FAILED TESTS: " + (total - passed) + " / " + total);
            throw ex;
        }
    }
}