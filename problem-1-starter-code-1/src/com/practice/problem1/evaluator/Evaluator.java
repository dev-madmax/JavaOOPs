package com.practice.problem1.evaluator;

import com.practice.problem1.models.Library;
import com.practice.problem1.models.Book;
import com.practice.problem1.exceptions.DuplicateEntityException;
import com.practice.problem1.exceptions.EntityNotFoundException;

public class Evaluator {
    public static void run() {
        // Test basic functionality
        Library library = new Library("Central Library", 100);
        
        // Test constructor and getters
        if (!library.getName().equals("Central Library")) {
            throw new RuntimeException("Library name getter failed");
        }
        if (library.getCapacity() != 100) {
            throw new RuntimeException("Library capacity getter failed");
        }
        if (library.getCurrentSize() != 0) {
            throw new RuntimeException("Initial library size should be 0");
        }
        
        // Test adding books
        Book book1 = new Book("978-0134685991", "Effective Java", "Joshua Bloch", 2017);
        Book book2 = new Book("978-0596009205", "Head First Design Patterns", "Eric Freeman", 2004);
        
        try {
            library.addBook(book1);
            if (library.getCurrentSize() != 1) {
                throw new RuntimeException("Adding book should increase size to 1");
            }
            
            library.addBook(book2);
            if (library.getCurrentSize() != 2) {
                throw new RuntimeException("Adding second book should increase size to 2");
            }
        } catch (Exception e) {
            throw new RuntimeException("Unexpected exception during book addition: " + e.getMessage());
        }
        
        // Test duplicate book addition
        Book duplicateBook = new Book("978-0134685991", "Effective Java", "Joshua Bloch", 2017);
        boolean duplicateThrown = false;
        try {
            library.addBook(duplicateBook);
        } catch (DuplicateEntityException e) {
            duplicateThrown = true;
        } catch (Exception e) {
            throw new RuntimeException("Wrong exception type thrown for duplicate book: " + e.getMessage());
        }
        if (!duplicateThrown) {
            throw new RuntimeException("Should throw DuplicateEntityException for duplicate ISBN");
        }
        
        // Test capacity limit
        Library smallLibrary = new Library("Small Library", 1);
        smallLibrary.addBook(book1);
        boolean capacityThrown = false;
        try {
            smallLibrary.addBook(book2);
        } catch (IllegalStateException e) {
            capacityThrown = true;
        } catch (Exception e) {
            throw new RuntimeException("Wrong exception type thrown for capacity exceeded: " + e.getMessage());
        }
        if (!capacityThrown) {
            throw new RuntimeException("Should throw IllegalStateException when capacity exceeded");
        }
        
        // Test find book
        Book foundBook = library.findBookByIsbn("978-0134685991");
        if (foundBook == null || !foundBook.getTitle().equals("Effective Java")) {
            throw new RuntimeException("Book lookup by ISBN failed");
        }
        
        // Test find non-existent book
        Book missingBook = library.findBookByIsbn("978-0000000000");
        if (missingBook != null) {
            throw new RuntimeException("Should return null for non-existent ISBN");
        }
        
        // Test remove book
        boolean removed = library.removeBookByIsbn("978-0134685991");
        if (!removed) {
            throw new RuntimeException("Failed to remove existing book");
        }
        if (library.getCurrentSize() != 1) {
            throw new RuntimeException("Removing book should decrease size to 1");
        }
        
        // Test remove non-existent book
        boolean notRemoved = library.removeBookByIsbn("978-0000000000");
        if (notRemoved) {
            throw new RuntimeException("Should not remove non-existent book");
        }
        
        // Test clear all books
        library.clearAllBooks();
        if (library.getCurrentSize() != 0) {
            throw new RuntimeException("Clearing library should result in size 0");
        }
        
        // Test book properties
        if (!book1.getIsbn().equals("978-0134685991")) {
            throw new RuntimeException("Book ISBN getter failed");
        }
        if (!book1.getTitle().equals("Effective Java")) {
            throw new RuntimeException("Book title getter failed");
        }
        if (!book1.getAuthor().equals("Joshua Bloch")) {
            throw new RuntimeException("Book author getter failed");
        }
        if (book1.getPublicationYear() != 2017) {
            throw new RuntimeException("Book publication year getter failed");
        }
        
        // Test book equals/hashCode with ISBN
        Book bookWithSameIsbn = new Book("978-0134685991", "Different Title", "Different Author", 2020);
        if (!book1.equals(bookWithSameIsbn)) {
            throw new RuntimeException("Books with same ISBN should be equal");
        }
        if (book1.hashCode() != bookWithSameIsbn.hashCode()) {
            throw new RuntimeException("Equal books should have same hash code");
        }
        
        System.out.println("PASS");
    }
}