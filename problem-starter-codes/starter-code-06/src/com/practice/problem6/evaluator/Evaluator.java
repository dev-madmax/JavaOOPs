package com.practice.problem6.evaluator;

import com.practice.problem6.services.*;
import com.practice.problem6.models.*;
import com.practice.problem6.exceptions.*;

/**
 * 🔒 LOCKED -- Students must not edit this file!
 *
 * Evaluates implementations for Coffee Shop Order System.
 * Run via Main.java.
 */
public class Evaluator {
    public static void run() {
        int passed = 0;
        int total = 22;

        try {
            OrderService service = new OrderService();

            // 1. Add customer
            Customer c1 = new Customer(1, "Alice");
            service.addCustomer(c1);
            passed++;

            // 2. Add menu item
            MenuItem m1 = new MenuItem("Espresso", 3.50);
            service.addMenuItem(m1);
            passed++;

            // 3. Add duplicate customer throws
            try {
                service.addCustomer(new Customer(1, "SomeoneElse"));
                throw new RuntimeException("Duplicate customer not detected");
            } catch (RuntimeException ex) {
                passed++;
            }

            // 4. Add duplicate menu item throws
            try {
                service.addMenuItem(new MenuItem("Espresso", 4.00));
                throw new RuntimeException("Duplicate menu item not detected");
            } catch (RuntimeException ex) {
                passed++;
            }

            // 5. Place order
            Order o1 = service.placeOrder(1, new String[]{"Espresso"});
            passed++;

            // 6. Orderable interface
            Orderable orderable = new MenuItem("Latte", 4.25);
            if (!orderable.getClass().getInterfaces()[0].getSimpleName().equals("Orderable")) throw new RuntimeException("Interface missing");
            passed++;

            // 7. Place order for unknown customer throws
            try {
                service.placeOrder(99, new String[]{"Espresso"});
                throw new RuntimeException("Unknown customer not detected");
            } catch (CustomerNotFoundException ex) {
                passed++;
            }

            // 8. Place order for unknown item throws
            try {
                service.placeOrder(1, new String[]{"UnknownItem"});
                throw new RuntimeException("Unknown item not detected");
            } catch (ItemNotFoundException ex) {
                passed++;
            }

            // 9. Get order details
            if (!o1.getStatus().equals("placed")) throw new RuntimeException("Order status wrong");
            passed++;

            // 10. Invalid order (no items) throws
            try {
                service.placeOrder(1, new String[]{});
                throw new RuntimeException("Empty order not detected");
            } catch (InvalidOrderException ex) {
                passed++;
            }

            // 11. Order status update
            o1.setStatus("completed");
            if (!o1.getStatus().equals("completed")) throw new RuntimeException("Order status update failed");
            passed++;

            // 12. Remove customer
            service.removeCustomer(1);
            try {
                service.placeOrder(1, new String[]{"Espresso"});
                throw new RuntimeException("Order for removed customer allowed");
            } catch (CustomerNotFoundException ex) {
                passed++;
            }

            // 13. Remove menu item
            service.removeMenuItem("Espresso");
            try {
                service.placeOrder(2, new String[]{"Espresso"});
                throw new RuntimeException("Order for removed item allowed");
            } catch (ItemNotFoundException ex) {
                passed++;
            }

            // 14. Null customer throws
            try {
                service.addCustomer(null);
                throw new RuntimeException("Null customer not detected");
            } catch (NullPointerException ex) {
                passed++;
            }

            // 15. Null menu item throws
            try {
                service.addMenuItem(null);
                throw new RuntimeException("Null menu item not detected");
            } catch (NullPointerException ex) {
                passed++;
            }

            // 16. Null item in order throws
            try {
                service.placeOrder(2, null);
                throw new RuntimeException("Null order items not detected");
            } catch (NullPointerException ex) {
                passed++;
            }

            // 17. Multiple orders
            for (int i = 10; i < 15; i++) {
                service.addCustomer(new Customer(i, "Cust"+i));
                service.addMenuItem(new MenuItem("Item"+i, i));
                service.placeOrder(i, new String[]{"Item"+i});
            }
            passed++;

            // 18. Remove order throws (not tracked)
            try {
                service.removeOrder("fakeOrderId");
                throw new RuntimeException("Remove non-existent order not detected");
            } catch (RuntimeException ex) {
                passed++;
            }

            // 19. Remove order happy
            Order o2 = service.placeOrder(10, new String[]{"Item10"});
            service.removeOrder(o2.getOrderId());
            passed++;

            // 20. Defensive: add many menu items
            for (int i = 100; i < 120; i++)
                service.addMenuItem(new MenuItem("MegaItem"+i, i));
            passed++;

            // 21. Defensive: place many orders
            for (int i = 100; i < 110; i++)
                service.placeOrder(10, new String[]{"MegaItem"+i});
            passed++;

            // 22. Defensive: remove menu item with active orders
            for (int i = 100; i < 110; i++)
                service.removeMenuItem("MegaItem"+i);
            passed++;

            System.out.println("ALL TESTS PASSED");
        } catch (RuntimeException ex) {
            System.out.println("FAILED TESTS: " + (total - passed) + " / " + total);
            throw ex;
        }
    }
}