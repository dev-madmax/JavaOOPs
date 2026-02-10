package com.practice.problem13.evaluator;

import com.practice.problem13.services.*;
import com.practice.problem13.models.*;
import com.practice.problem13.exceptions.*;

/**
 * 🔒 LOCKED -- Students must not edit this file!
 *
 * Evaluates implementations for Pet Adoption Center.
 * Run via Main.java.
 */
public class Evaluator {
    public static void run() {
        int passed = 0;
        int total = 24;

        try {
            AdoptionService service = new AdoptionService();

            // 1. Add adopter
            Adopter a1 = new Adopter(1, "Alice");
            service.addAdopter(a1);
            passed++;

            // 2. Add another adopter
            Adopter a2 = new Adopter(2, "Bob");
            service.addAdopter(a2);
            passed++;

            // 3. Duplicate adopter throws
            try {
                service.addAdopter(new Adopter(1, "SomeoneElse"));
                throw new RuntimeException("Duplicate adopter not detected");
            } catch (RuntimeException ex) {
                passed++;
            }

            // 4. Add pet
            Pet p1 = new Pet("Dog101", "Dog", "Brown");
            service.addPet(p1);
            passed++;

            // 5. Add another pet
            Pet p2 = new Pet("Cat102", "Cat", "White");
            service.addPet(p2);
            passed++;

            // 6. Duplicate pet throws
            try {
                service.addPet(new Pet("Dog101", "Dog", "Black"));
                throw new RuntimeException("Duplicate pet not detected");
            } catch (RuntimeException ex) {
                passed++;
            }

            // 7. Adopt pet for Alice
            Adoption ad1 = service.adoptPet(1, "Dog101");
            passed++;

            // 8. Pet status adopted
            if (!service.isPetAdopted("Dog101")) throw new RuntimeException("Pet adoption state not set");
            passed++;

            // 9. Adopt same pet for Bob throws PetNotAvailableException
            try {
                service.adoptPet(2, "Dog101");
                throw new RuntimeException("Unavailable pet adoption not detected");
            } catch (PetNotAvailableException ex) {
                passed++;
            }

            // 10. Adopt with non-existent adopter
            try {
                service.adoptPet(99, "Cat102");
                throw new RuntimeException("Non-existent adopter not detected");
            } catch (AdopterNotFoundException ex) {
                passed++;
            }

            // 11. Adopt non-existent pet
            try {
                service.adoptPet(1, "Fish103");
                throw new RuntimeException("Non-existent pet not detected");
            } catch (PetNotAvailableException ex) {
                passed++;
            }

            // 12. Cancel adoption
            service.cancelAdoption(ad1.getAdoptionId());
            if (service.isPetAdopted("Dog101")) throw new RuntimeException("Pet not released from adoption");
            passed++;

            // 13. Cancel adoption not found
            try {
                service.cancelAdoption("FAKEID");
                throw new RuntimeException("Cancel of not found adoption not detected");
            } catch (InvalidAdoptionException ex) {
                passed++;
            }

            // 14. Adopt after cancel
            Adoption ad2 = service.adoptPet(2, "Dog101");
            if (!service.isPetAdopted("Dog101")) throw new RuntimeException("Adoption after cancel failed");
            passed++;

            // 15. Null pet handling
            try {
                service.addPet(null);
                throw new RuntimeException("Null pet not detected");
            } catch (NullPointerException ex) {
                passed++;
            }

            // 16. Null adopter handling
            try {
                service.addAdopter(null);
                throw new RuntimeException("Null adopter not detected");
            } catch (NullPointerException ex) {
                passed++;
            }

            // 17. Adopt nulls
            try {
                service.adoptPet(1, null);
                throw new RuntimeException("Null pet id not detected");
            } catch (NullPointerException ex) {
                passed++;
            }

            // 18. Cancel null adoption id
            try {
                service.cancelAdoption(null);
                throw new RuntimeException("Null adoption id not detected");
            } catch (NullPointerException ex) {
                passed++;
            }

            // 19. Remove adopter
            service.removeAdopter(2);
            try {
                service.adoptPet(2, "Cat102");
                throw new RuntimeException("Adoption for removed adopter allowed");
            } catch (AdopterNotFoundException ex) {
                passed++;
            }

            // 20. Remove pet
            service.removePet("Cat102");
            try {
                service.adoptPet(1, "Cat102");
                throw new RuntimeException("Adoption for removed pet allowed");
            } catch (PetNotAvailableException ex) {
                passed++;
            }

            // 21. Capacity: add many pets/adopters/adoptions
            for (int i = 200; i < 210; i++) {
                service.addPet(new Pet("Pet"+i, "Type"+i, "Color"+i));
                service.addAdopter(new Adopter(i, "Adopter"+i));
                service.adoptPet(i, "Pet"+i);
            }
            passed++;

            // 22. Defensive: pet boundaries
            try {
                service.addPet(new Pet("", "Dog", "Brown"));
                throw new RuntimeException("Empty pet id not detected");
            } catch (RuntimeException ex) {
                passed++;
            }

            // 23. Defensive: adopter boundaries
            try {
                service.addAdopter(new Adopter(-1, "Invalid"));
                throw new RuntimeException("Negative adopter id not detected");
            } catch (RuntimeException ex) {
                passed++;
            }

            // 24. Adoptable interface check
            Adoptable pet = new Pet("Dog105", "Dog", "Red");
            pet.adopt();
            pet.returnPet();
            passed++;

            System.out.println("ALL TESTS PASSED");
        } catch (RuntimeException ex) {
            System.out.println("FAILED TESTS: " + (total - passed) + " / " + total);
            throw ex;
        }
    }
}