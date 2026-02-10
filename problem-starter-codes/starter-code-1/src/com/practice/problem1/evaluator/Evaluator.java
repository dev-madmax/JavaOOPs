package com.practice.problem1.evaluator;

import com.practice.problem1.models.*;
import com.practice.problem1.services.*;
import com.practice.problem1.exceptions.*;

/**
 * 🔒 LOCKED -- Students must not edit this file!
 *
 * Evaluates implementations for Library Book Management System.
 * Run via Main.java.
 */
public class Evaluator {
    public static void run() {
        int passed = 0;
        int total = 24;

        // Start tests
        try {
            LibraryService service = new LibraryService();

            // 1. Add book
            Book b1 = new Book("ISBN123", "Clean Code", "Robert Martin");
            service.addBook(b1);
            passed++;

            // 2. Add another book
            Book b2 = new Book("ISBN456", "Effective Java", "Joshua Bloch");
            service.addBook(b2);
            passed++;

            // 3. Duplicate add throws exception
            try {
                service.addBook(new Book("ISBN123", "Some Book", "Someone"));
                throw new RuntimeException("Duplicate ISBN not detected");
            } catch (RuntimeException ex) {
                passed++;
            }

            // 4. Add member
            Member m1 = new Member(1, "Alice");
            service.addMember(m1);
            passed++;

            // 5. Add another member
            Member m2 = new Member(2, "Bob");
            service.addMember(m2);
            passed++;

            // 6. Duplicate member throws
            try {
                service.addMember(new Member(1, "SomeoneElse"));
                throw new RuntimeException("Duplicate member not detected");
            } catch (RuntimeException ex) {
                passed++;
            }

            // 7. Borrow book
            service.borrowBook(1, "ISBN123");
            passed++;

            // 8. Book status borrowed
            if (!service.isBookBorrowed("ISBN123")) throw new RuntimeException("Borrow state not set");
            passed++;

            // 9. Borrow same book again throws BookAlreadyBorrowedException
            try {
                service.borrowBook(2, "ISBN123");
                throw new RuntimeException("Borrowed unavailable book not detected");
            } catch (BookAlreadyBorrowedException ex) {
                if (!ex.getMessage().contains("already borrowed")) throw new RuntimeException("Wrong message");
                passed++;
            }

            // 10. Borrow with non-existent member
            try {
                service.borrowBook(99, "ISBN456");
                throw new RuntimeException("Non-existent member not detected");
            } catch (MemberNotFoundException ex) {
                passed++;
            }

            // 11. Borrow non-existent book
            try {
                service.borrowBook(1, "FAKEISBN");
                throw new RuntimeException("Non-existent book not detected");
            } catch (BookNotFoundException ex) {
                passed++;
            }

            // 12. Return book
            service.returnBook(1, "ISBN123");
            if (service.isBookBorrowed("ISBN123")) throw new RuntimeException("Book not returned");
            passed++;

            // 13. Return book not borrowed
            try {
                service.returnBook(1, "ISBN123");
                throw new RuntimeException("Return of not borrowed book not detected");
            } catch (RuntimeException ex) {
                passed++;
            }

            // 14. Borrow after return
            service.borrowBook(2, "ISBN123");
            if (!service.isBookBorrowed("ISBN123")) throw new RuntimeException("Borrow after return failed");
            passed++;

            // 15. Null book handling
            try {
                service.addBook(null);
                throw new RuntimeException("Null book not detected");
            } catch (NullPointerException ex) {
                passed++;
            }

            // 16. Null member handling
            try {
                service.addMember(null);
                throw new RuntimeException("Null member not detected");
            } catch (NullPointerException ex) {
                passed++;
            }

            // 17. Borrow nulls
            try {
                service.borrowBook(1, null);
                throw new RuntimeException("Null ISBN not detected");
            } catch (NullPointerException ex) {
                passed++;
            }

            // 18. Return nulls
            try {
                service.returnBook(1, null);
                throw new RuntimeException("Null ISBN (return) not detected");
            } catch (NullPointerException ex) {
                passed++;
            }

            // 19. Remove book
            service.removeBook("ISBN456");
            try {
                service.borrowBook(1, "ISBN456");
                throw new RuntimeException("Removed book not detected");
            } catch (BookNotFoundException ex) {
                passed++;
            }

            // 20. Remove member
            service.removeMember(2);
            try {
                service.borrowBook(2, "ISBN123");
                throw new RuntimeException("Removed member not detected");
            } catch (MemberNotFoundException ex) {
                passed++;
            }

            // 21. Capacity: add many books
            for (int i = 1000; i < 1020; i++) {
                service.addBook(new Book("ISBN" + i, "Book"+i, "Gen Author"));
            }
            passed++;

            // 22. Capacity: add many members
            for (int i = 1000; i < 1020; i++) {
                service.addMember(new Member(i, "User"+i));
            }
            passed++;

            // 23. Repeat borrow/return
            service.borrowBook(1001, "ISBN1001");
            service.returnBook(1001, "ISBN1001");
            service.borrowBook(1001, "ISBN1001");
            passed++;

            // 24. Defensive: check not borrowed after remove book
            service.removeBook("ISBN1001");
            try {
                service.isBookBorrowed("ISBN1001");
                throw new RuntimeException("isBookBorrowed on removed book not detected");
            } catch (BookNotFoundException ex) {
                passed++;
            }

            System.out.println("ALL TESTS PASSED");
        } catch (RuntimeException ex) {
            System.out.println("FAILED TESTS: " + (total - passed) + " / " + total);
            throw ex;
        }
    }
}