package com.practice.problem15.evaluator;

import com.practice.problem15.services.*;
import com.practice.problem15.models.*;
import com.practice.problem15.exceptions.*;

/**
 * 🔒 LOCKED -- Students must not edit this file!
 *
 * Evaluates implementations for Farm Crop Management System.
 * Run via Main.java.
 */
public class Evaluator {
    public static void run() {
        int passed = 0;
        int total = 22;

        try {
            CropService service = new CropService();

            // 1. Add crop
            Crop c1 = new Crop("Wheat", "Spring");
            service.addCrop(c1);
            passed++;

            // 2. Add another crop
            Crop c2 = new Crop("Corn", "Summer");
            service.addCrop(c2);
            passed++;

            // 3. Duplicate crop throws
            try {
                service.addCrop(new Crop("Wheat", "Winter"));
                throw new RuntimeException("Duplicate crop not detected");
            } catch (DuplicateCropException ex) {
                passed++;
            }

            // 4. Add field
            Field f1 = new Field("FieldA", 25);
            passed++;

            // 5. Plant crop in field
            service.plantCrop("Wheat", "FieldA");
            passed++;

            // 6. Plant unknown crop throws
            try {
                service.plantCrop("Barley", "FieldA");
                throw new RuntimeException("Unknown crop not detected");
            } catch (CropNotFoundException ex) {
                passed++;
            }

            // 7. Growable interface
            Growable grow = new Crop("Rice", "Monsoon");
            if (!grow.getClass().getInterfaces()[0].getSimpleName().equals("Growable")) throw new RuntimeException("Interface missing");
            passed++;

            // 8. Harvest crop happy
            HarvestRecord record = service.harvestCrop("Wheat", "FieldA", "2026-01-10");
            if (!record.getField().equals("FieldA")) throw new RuntimeException("Harvest record wrong");
            passed++;

            // 9. Harvest non-existent crop throws
            try {
                service.harvestCrop("Barley", "FieldA", "2026-01-10");
                throw new RuntimeException("Harvest unknown crop not detected");
            } catch (CropNotFoundException ex) {
                passed++;
            }

            // 10. Remove crop happy
            service.removeCrop("Corn");
            try {
                service.plantCrop("Corn", "FieldA");
                throw new RuntimeException("Plant removed crop allowed");
            } catch (CropNotFoundException ex) {
                passed++;
            }

            // 11. Remove unknown crop throws
            try {
                service.removeCrop("Barley");
                throw new RuntimeException("Remove unknown crop not detected");
            } catch (CropNotFoundException ex) {
                passed++;
            }

            // 12. Null crop throws
            try {
                service.addCrop(null);
                throw new RuntimeException("Null crop not detected");
            } catch (NullPointerException ex) {
                passed++;
            }

            // 13. Null field throws
            try {
                service.plantCrop("Wheat", null);
                throw new RuntimeException("Null field not detected");
            } catch (NullPointerException ex) {
                passed++;
            }

            // 14. Defensive: add many crops/fields
            for (int i = 100; i < 120; i++) {
                service.addCrop(new Crop("Crop"+i, "Season"+i));
            }
            passed++;

            // 15. Defensive: plant in many fields
            for (int i = 100; i < 120; i++) {
                service.plantCrop("Crop"+i, "Field"+i);
            }
            passed++;

            // 16. Defensive: harvest boundary values
            for (int i = 100; i < 110; i++) {
                service.harvestCrop("Crop"+i, "Field"+i, "2026-02-10");
            }
            passed++;

            // 17. Remove crop with harvest records
            service.removeCrop("Crop100");
            try {
                service.harvestCrop("Crop100", "Field100", "2026-02-11");
                throw new RuntimeException("Harvest removed crop allowed");
            } catch (CropNotFoundException ex) {
                passed++;
            }

            // 18. Defensive: add empty crop name throws
            try {
                service.addCrop(new Crop("", "Spring"));
                throw new RuntimeException("Empty crop name not detected");
            } catch (RuntimeException ex) {
                passed++;
            }

            // 19. Defensive: invalid harvest date
            try {
                service.harvestCrop("Wheat", "FieldA", "invalid-date");
                throw new RuntimeException("Invalid harvest date not detected");
            } catch (InvalidHarvestException ex) {
                passed++;
            }

            // 20. Defensive: plant crop in empty field throws
            try {
                service.plantCrop("Wheat", "");
                throw new RuntimeException("Empty field name not detected");
            } catch (RuntimeException ex) {
                passed++;
            }

            // 21. Defensive: remove all crops
            for (int i = 100; i < 120; i++) {
                service.removeCrop("Crop"+i);
            }
            passed++;

            // 22. Defensive: harvest after all removals throws
            try {
                service.harvestCrop("Crop119", "Field119", "2026-03-01");
                throw new RuntimeException("Harvest after all removals allowed");
            } catch (CropNotFoundException ex) {
                passed++;
            }

            System.out.println("ALL TESTS PASSED");
        } catch (RuntimeException ex) {
            System.out.println("FAILED TESTS: " + (total - passed) + " / " + total);
            throw ex;
        }
    }
}