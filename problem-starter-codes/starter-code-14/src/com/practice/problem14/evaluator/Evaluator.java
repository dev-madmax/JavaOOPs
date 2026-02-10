package com.practice.problem14.evaluator;

import com.practice.problem14.services.*;
import com.practice.problem14.models.*;
import com.practice.problem14.exceptions.*;

/**
 * 🔒 LOCKED -- Students must not edit this file!
 *
 * Evaluates implementations for Movie Theater Ticketing System.
 * Run via Main.java.
 */
public class Evaluator {
    public static void run() {
        int passed = 0;
        int total = 24;

        try {
            TicketService service = new TicketService();

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

            // 4. Add movie
            Movie m1 = new Movie("MOV101", "Inception", "2024-09-01", 100);
            service.addMovie(m1);
            passed++;

            // 5. Add another movie
            Movie m2 = new Movie("MOV102", "Matrix", "2024-10-05", 120);
            service.addMovie(m2);
            passed++;

            // 6. Duplicate movie throws
            try {
                service.addMovie(new Movie("MOV101", "Tenet", "2024-11-01", 110));
                throw new RuntimeException("Duplicate movie not detected");
            } catch (RuntimeException ex) {
                passed++;
            }

            // 7. Book ticket for Alice
            Ticket t1 = service.bookTicket(1, "MOV101");
            passed++;

            // 8. Movie status booked
            if (!service.isTicketBooked("MOV101", 1)) throw new RuntimeException("Ticket booking state not set");
            passed++;

            // 9. Book same movie for Bob throws MovieNotAvailableException (simulate full seats)
            try {
                service.bookTicket(2, "MOV101");
                throw new RuntimeException("Unavailable movie booking not detected");
            } catch (MovieNotAvailableException ex) {
                passed++;
            }

            // 10. Book with non-existent customer
            try {
                service.bookTicket(99, "MOV102");
                throw new RuntimeException("Non-existent customer not detected");
            } catch (CustomerNotFoundException ex) {
                passed++;
            }

            // 11. Book non-existent movie
            try {
                service.bookTicket(1, "MOV999");
                throw new RuntimeException("Non-existent movie not detected");
            } catch (MovieNotAvailableException ex) {
                passed++;
            }

            // 12. Cancel ticket
            service.cancelTicket(t1.getTicketId());
            if (service.isTicketBooked("MOV101", 1)) throw new RuntimeException("Ticket not released from booking");
            passed++;

            // 13. Cancel ticket not found
            try {
                service.cancelTicket("FAKEID");
                throw new RuntimeException("Cancel of not found ticket not detected");
            } catch (InvalidTicketException ex) {
                passed++;
            }

            // 14. Book after cancel
            Ticket t2 = service.bookTicket(2, "MOV101");
            if (!service.isTicketBooked("MOV101", 2)) throw new RuntimeException("Booking after cancel failed");
            passed++;

            // 15. Null movie handling
            try {
                service.addMovie(null);
                throw new RuntimeException("Null movie not detected");
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

            // 17. Book nulls
            try {
                service.bookTicket(1, null);
                throw new RuntimeException("Null movie id not detected");
            } catch (NullPointerException ex) {
                passed++;
            }

            // 18. Cancel null ticket id
            try {
                service.cancelTicket(null);
                throw new RuntimeException("Null ticket id not detected");
            } catch (NullPointerException ex) {
                passed++;
            }

            // 19. Remove customer
            service.removeCustomer(2);
            try {
                service.bookTicket(2, "MOV102");
                throw new RuntimeException("Booking for removed customer allowed");
            } catch (CustomerNotFoundException ex) {
                passed++;
            }

            // 20. Remove movie
            service.removeMovie("MOV102");
            try {
                service.bookTicket(1, "MOV102");
                throw new RuntimeException("Booking for removed movie allowed");
            } catch (MovieNotAvailableException ex) {
                passed++;
            }

            // 21. Capacity: add many movies/customers/tickets
            for (int i = 200; i < 210; i++) {
                service.addMovie(new Movie("M"+i, "Title"+i, "2025-01-01", 1));
                service.addCustomer(new Customer(i, "Customer"+i));
                service.bookTicket(i, "M"+i);
            }
            passed++;

            // 22. Defensive: movie boundaries
            try {
                service.addMovie(new Movie("", "MovieX", "2026-01-01", 1));
                throw new RuntimeException("Empty movie id not detected");
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

            // 24. Ticketable interface check
            Ticketable movie = new Movie("MOV105", "Hero", "2026-02-10", 150);
            movie.book();
            movie.cancel();
            passed++;

            System.out.println("ALL TESTS PASSED");
        } catch (RuntimeException ex) {
            System.out.println("FAILED TESTS: " + (total - passed) + " / " + total);
            throw ex;
        }
    }
}