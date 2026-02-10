package com.practice.problem7.evaluator;

import com.practice.problem7.services.*;
import com.practice.problem7.models.*;
import com.practice.problem7.exceptions.*;

/**
 * 🔒 LOCKED -- Students must not edit this file!
 *
 * Evaluates implementations for Zoo Animal Feeding System.
 * Run via Main.java.
 */
public class Evaluator {
    public static void run() {
        int passed = 0;
        int total = 22;

        try {
            FeedingService service = new FeedingService();

            // 1. Add animal
            Animal a1 = new Animal("Leo", "Lion");
            service.addAnimal(a1);
            passed++;

            // 2. Add another animal
            Animal a2 = new Animal("Ellie", "Elephant");
            service.addAnimal(a2);
            passed++;

            // 3. Duplicate animal throws
            try {
                service.addAnimal(new Animal("Leo", "Panther"));
                throw new RuntimeException("Duplicate animal not detected");
            } catch (RuntimeException ex) {
                passed++;
            }

            // 4. Mark feeding
            service.markFeeding("Leo", "Beef", "2024-02-11");
            passed++;

            // 5. Mark feeding again same day throws
            try {
                service.markFeeding("Leo", "Beef", "2024-02-11");
                throw new RuntimeException("Duplicate feeding not detected");
            } catch (DuplicateFeedingException ex) {
                passed++;
            }

            // 6. Mark feeding for unknown animal throws
            try {
                service.markFeeding("Unknown", "Grass", "2024-02-11");
                throw new RuntimeException("Unknown animal not detected");
            } catch (AnimalNotFoundException ex) {
                passed++;
            }

            // 7. Mark feeding with invalid food throws
            try {
                service.markFeeding("Leo", null, "2024-02-11");
                throw new RuntimeException("Invalid food not detected");
            } catch (InvalidFoodException ex) {
                passed++;
            }

            // 8. Feeding record happy
            FeedingRecord fr = service.getFeedingRecord("Leo", "2024-02-11");
            if (!fr.getAnimalName().equals("Leo")) throw new RuntimeException("Feeding record wrong");
            passed++;

            // 9. Get feeding record not found throws
            try {
                service.getFeedingRecord("Leo", "2024-01-01");
                throw new RuntimeException("No feeding record not detected");
            } catch (RuntimeException ex) {
                passed++;
            }

            // 10. Remove animal
            service.removeAnimal("Ellie");
            try {
                service.markFeeding("Ellie", "Banana", "2024-02-12");
                throw new RuntimeException("Feeding for removed animal allowed");
            } catch (AnimalNotFoundException ex) {
                passed++;
            }

            // 11. Null animal throws
            try {
                service.addAnimal(null);
                throw new RuntimeException("Null animal not detected");
            } catch (NullPointerException ex) {
                passed++;
            }

            // 12. Null food throws
            try {
                service.markFeeding("Leo", null, "2024-02-11");
                throw new RuntimeException("Null food not detected");
            } catch (InvalidFoodException ex) {
                passed++;
            }

            // 13. Null date throws
            try {
                service.markFeeding("Leo", "Beef", null);
                throw new RuntimeException("Null date not detected");
            } catch (NullPointerException ex) {
                passed++;
            }

            // 14. Feedable interface
            Feedable f = new Animal("Tiger", "Tiger");
            if (!f.getClass().getInterfaces()[0].getSimpleName().equals("Feedable")) throw new RuntimeException("Interface missing");
            passed++;

            // 15. Defensive: multiple feeding records
            for (int i = 0; i < 10; i++)
                service.addAnimal(new Animal("Animal" + i, "Species" + i));
            for (int i = 0; i < 10; i++)
                service.markFeeding("Animal" + i, "Food" + i, "2024-03-01");
            passed++;

            // 16. Remove feeding record throws (untracked)
            try {
                service.removeFeedingRecord("Leo", "2023-01-01");
                throw new RuntimeException("Remove non-existent feeding not detected");
            } catch (RuntimeException ex) {
                passed++;
            }

            // 17. Remove feeding record happy
            service.removeFeedingRecord("Leo", "2024-02-11");
            try {
                service.getFeedingRecord("Leo", "2024-02-11");
                throw new RuntimeException("Feeding record not removed");
            } catch (RuntimeException ex) {
                passed++;
            }

            // 18. Defensive: add many animals
            for (int i = 100; i < 120; i++)
                service.addAnimal(new Animal("MegaAnimal" + i, "MegaSpecies" + i));
            passed++;

            // 19. Defensive: mark many feedings
            for (int i = 100; i < 110; i++)
                service.markFeeding("MegaAnimal" + i, "MegaFood" + i, "2026-02-10");
            passed++;

            // 20. Defensive: remove animal with feedings
            service.removeAnimal("Animal0");
            try {
                service.getFeedingRecord("Animal0", "2024-03-01");
                throw new RuntimeException("Feeding record for removed animal allowed");
            } catch (RuntimeException ex) {
                passed++;
            }

            // 21. Defensive: feeding boundary values
            service.markFeeding("Tiger", "Chicken", "2022-02-12");
            service.markFeeding("Tiger", "Beef", "2025-12-11");
            passed++;

            // 22. Remove animal with wildcard removes feedings
            service.removeAnimal("Tiger");
            try {
                service.getFeedingRecord("Tiger", "2022-02-12");
                throw new RuntimeException("Feeding record for removed animal allowed");
            } catch (RuntimeException ex) {
                passed++;
            }

            System.out.println("ALL TESTS PASSED");
        } catch (RuntimeException ex) {
            System.out.println("FAILED TESTS: " + (total - passed) + " / " + total);
            throw ex;
        }
    }
}