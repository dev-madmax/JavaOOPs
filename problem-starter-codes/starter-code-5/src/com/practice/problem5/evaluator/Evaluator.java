package com.practice.problem5.evaluator;

import com.practice.problem5.services.*;
import com.practice.problem5.models.*;
import com.practice.problem5.exceptions.*;

/**
 * 🔒 LOCKED -- Students must not edit this file!
 *
 * Evaluates implementations for Hotel Room Booking System.
 * Run via Main.java.
 */
public class Evaluator {
    public static void run() {
        int passed = 0;
        int total = 24;

        try {
            BookingService service = new BookingService();

            // 1. Add guest
            Guest g1 = new Guest(1, "Alice");
            service.addGuest(g1);
            passed++;

            // 2. Add another guest
            Guest g2 = new Guest(2, "Bob");
            service.addGuest(g2);
            passed++;

            // 3. Duplicate guest throws
            try {
                service.addGuest(new Guest(1, "SomeoneElse"));
                throw new RuntimeException("Duplicate guest not detected");
            } catch (RuntimeException ex) {
                passed++;
            }

            // 4. Add room
            Room r1 = new Room(101, "Single");
            service.addRoom(r1);
            passed++;

            // 5. Add another room
            Room r2 = new Room(102, "Double");
            service.addRoom(r2);
            passed++;

            // 6. Duplicate room throws
            try {
                service.addRoom(new Room(101, "King"));
                throw new RuntimeException("Duplicate room not detected");
            } catch (RuntimeException ex) {
                passed++;
            }

            // 7. Book room for Alice
            Booking b1 = service.bookRoom(1, 101, "2024-03-01", "2024-03-05");
            passed++;

            // 8. Room status booked
            if (!service.isRoomBooked(101)) throw new RuntimeException("Room state not set");
            passed++;

            // 9. Book same room for Bob throws RoomNotAvailableException
            try {
                service.bookRoom(2, 101, "2024-03-02", "2024-03-04");
                throw new RuntimeException("Unavailable room booking not detected");
            } catch (RoomNotAvailableException ex) {
                passed++;
            }

            // 10. Book with non-existent guest
            try {
                service.bookRoom(99, 102, "2024-03-10", "2024-03-12");
                throw new RuntimeException("Non-existent guest not detected");
            } catch (GuestNotFoundException ex) {
                passed++;
            }

            // 11. Book non-existent room
            try {
                service.bookRoom(1, 999, "2024-03-10", "2024-03-12");
                throw new RuntimeException("Non-existent room not detected");
            } catch (RoomNotAvailableException ex) {
                passed++;
            }

            // 12. Cancel booking
            service.cancelBooking(b1.getBookingId());
            if (service.isRoomBooked(101)) throw new RuntimeException("Room not released");
            passed++;

            // 13. Cancel booking not found
            try {
                service.cancelBooking("FAKEID");
                throw new RuntimeException("Cancel of not found booking not detected");
            } catch (InvalidBookingException ex) {
                passed++;
            }

            // 14. Book after cancel
            Booking b2 = service.bookRoom(2, 101, "2024-03-06", "2024-03-08");
            if (!service.isRoomBooked(101)) throw new RuntimeException("Booking after cancel failed");
            passed++;

            // 15. Null room handling
            try {
                service.addRoom(null);
                throw new RuntimeException("Null room not detected");
            } catch (NullPointerException ex) {
                passed++;
            }

            // 16. Null guest handling
            try {
                service.addGuest(null);
                throw new RuntimeException("Null guest not detected");
            } catch (NullPointerException ex) {
                passed++;
            }

            // 17. Book nulls
            try {
                service.bookRoom(1, 101, null, "2024-03-10");
                throw new RuntimeException("Null start date not detected");
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

            // 19. Remove guest
            service.removeGuest(2);
            try {
                service.bookRoom(2, 102, "2024-03-10", "2024-03-15");
                throw new RuntimeException("Booking for removed guest allowed");
            } catch (GuestNotFoundException ex) {
                passed++;
            }

            // 20. Remove room
            service.removeRoom(102);
            try {
                service.bookRoom(1, 102, "2024-03-10", "2024-03-15");
                throw new RuntimeException("Booking for removed room allowed");
            } catch (RoomNotAvailableException ex) {
                passed++;
            }

            // 21. Capacity: add many rooms/guests/bookings
            for (int i = 200; i < 210; i++) {
                service.addRoom(new Room(i, "Single"));
                service.addGuest(new Guest(i, "Guest"+i));
                service.bookRoom(i, i, "2024-05-10", "2024-05-20");
            }
            passed++;

            // 22. Defensive: room boundaries
            try {
                service.addRoom(new Room(-1, "Invalid"));
                throw new RuntimeException("Negative room number not detected");
            } catch (RuntimeException ex) {
                passed++;
            }

            // 23. Defensive: guest boundaries
            try {
                service.addGuest(new Guest(-1, "Invalid"));
                throw new RuntimeException("Negative guest id not detected");
            } catch (RuntimeException ex) {
                passed++;
            }

            // 24. Bookable interface check
            Bookable r = new Room(203, "Single");
            r.book("2024-03-01", "2024-03-05");
            r.unbook();
            passed++;

            System.out.println("ALL TESTS PASSED");
        } catch (RuntimeException ex) {
            System.out.println("FAILED TESTS: " + (total - passed) + " / " + total);
            throw ex;
        }
    }
}