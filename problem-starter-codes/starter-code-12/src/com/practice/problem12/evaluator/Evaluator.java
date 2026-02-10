package com.practice.problem12.evaluator;

import com.practice.problem12.services.*;
import com.practice.problem12.models.*;
import com.practice.problem12.exceptions.*;

/**
 * 🔒 LOCKED -- Students must not edit this file!
 *
 * Evaluates implementations for Flight Booking System.
 * Run via Main.java.
 */
public class Evaluator {
    public static void run() {
        int passed = 0;
        int total = 24;

        try {
            BookingService service = new BookingService();

            // 1. Add passenger
            Passenger p1 = new Passenger(1, "Alice");
            service.addPassenger(p1);
            passed++;

            // 2. Add another passenger
            Passenger p2 = new Passenger(2, "Bob");
            service.addPassenger(p2);
            passed++;

            // 3. Duplicate passenger throws
            try {
                service.addPassenger(new Passenger(1, "SomeoneElse"));
                throw new RuntimeException("Duplicate passenger not detected");
            } catch (RuntimeException ex) {
                passed++;
            }

            // 4. Add flight
            Flight f1 = new Flight("AA100", "NYC", "LAX", "2024-06-01", 100);
            service.addFlight(f1);
            passed++;

            // 5. Add another flight
            Flight f2 = new Flight("BB200", "SFO", "ORD", "2024-07-15", 200);
            service.addFlight(f2);
            passed++;

            // 6. Duplicate flight throws
            try {
                service.addFlight(new Flight("AA100", "SEA", "MIA", "2024-08-01", 150));
                throw new RuntimeException("Duplicate flight not detected");
            } catch (RuntimeException ex) {
                passed++;
            }

            // 7. Book flight for Alice
            Reservation r1 = service.bookFlight(1, "AA100");
            passed++;

            // 8. Flight status booked
            if (!service.isFlightBooked("AA100", 1)) throw new RuntimeException("Flight booking state not set");
            passed++;

            // 9. Book same flight for Bob throws FlightNotAvailableException (simulate full flight)
            try {
                service.bookFlight(2, "AA100");
                throw new RuntimeException("Unavailable flight booking not detected");
            } catch (FlightNotAvailableException ex) {
                passed++;
            }

            // 10. Book with non-existent passenger
            try {
                service.bookFlight(99, "BB200");
                throw new RuntimeException("Non-existent passenger not detected");
            } catch (PassengerNotFoundException ex) {
                passed++;
            }

            // 11. Book non-existent flight
            try {
                service.bookFlight(1, "ZZ999");
                throw new RuntimeException("Non-existent flight not detected");
            } catch (FlightNotAvailableException ex) {
                passed++;
            }

            // 12. Cancel booking
            service.cancelBooking(r1.getBookingId());
            if (service.isFlightBooked("AA100", 1)) throw new RuntimeException("Flight not released from booking");
            passed++;

            // 13. Cancel booking not found
            try {
                service.cancelBooking("FAKEID");
                throw new RuntimeException("Cancel of not found booking not detected");
            } catch (InvalidBookingException ex) {
                passed++;
            }

            // 14. Book after cancel
            Reservation r2 = service.bookFlight(2, "AA100");
            if (!service.isFlightBooked("AA100", 2)) throw new RuntimeException("Booking after cancel failed");
            passed++;

            // 15. Null flight handling
            try {
                service.addFlight(null);
                throw new RuntimeException("Null flight not detected");
            } catch (NullPointerException ex) {
                passed++;
            }

            // 16. Null passenger handling
            try {
                service.addPassenger(null);
                throw new RuntimeException("Null passenger not detected");
            } catch (NullPointerException ex) {
                passed++;
            }

            // 17. Book nulls
            try {
                service.bookFlight(1, null);
                throw new RuntimeException("Null flight number not detected");
            } catch (NullPointerException ex) {
                passed++;
            }

            // 18. Cancel null booking id
            try {
                service.cancelBooking(null);
                throw new RuntimeException("Null booking id not detected");
            } catch (NullPointerException ex) {
                passed++;
            }

            // 19. Remove passenger
            service.removePassenger(2);
            try {
                service.bookFlight(2, "BB200");
                throw new RuntimeException("Booking for removed passenger allowed");
            } catch (PassengerNotFoundException ex) {
                passed++;
            }

            // 20. Remove flight
            service.removeFlight("BB200");
            try {
                service.bookFlight(1, "BB200");
                throw new RuntimeException("Booking for removed flight allowed");
            } catch (FlightNotAvailableException ex) {
                passed++;
            }

            // 21. Capacity: add many flights/passengers/bookings
            for (int i = 200; i < 210; i++) {
                service.addFlight(new Flight("F"+i, "A"+i, "B"+i, "2025-01-01", 1));
                service.addPassenger(new Passenger(i, "Passenger"+i));
                service.bookFlight(i, "F"+i);
            }
            passed++;

            // 22. Defensive: flight boundaries
            try {
                service.addFlight(new Flight("", "NYC", "LAX", "2026-01-01", 1));
                throw new RuntimeException("Empty flight number not detected");
            } catch (RuntimeException ex) {
                passed++;
            }

            // 23. Defensive: passenger boundaries
            try {
                service.addPassenger(new Passenger(-1, "Invalid"));
                throw new RuntimeException("Negative passenger id not detected");
            } catch (RuntimeException ex) {
                passed++;
            }

            // 24. Bookable interface check
            Bookable f = new Flight("CC300", "NYC", "SFO", "2026-02-10", 150);
            f.book();
            f.cancel();
            passed++;

            System.out.println("ALL TESTS PASSED");
        } catch (RuntimeException ex) {
            System.out.println("FAILED TESTS: " + (total - passed) + " / " + total);
            throw ex;
        }
    }
}