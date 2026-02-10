package com.practice.problem9.evaluator;

import com.practice.problem9.services.*;
import com.practice.problem9.models.*;
import com.practice.problem9.exceptions.*;

/**
 * 🔒 LOCKED -- Students must not edit this file!
 *
 * Evaluates implementations for Gym Membership System.
 * Run via Main.java.
 */
public class Evaluator {
    public static void run() {
        int passed = 0;
        int total = 22;

        try {
            MembershipService service = new MembershipService();

            // 1. Add member
            Member m1 = new Member(1, "Alice");
            service.addMember(m1);
            passed++;

            // 2. Add another member
            Member m2 = new Member(2, "Bob");
            service.addMember(m2);
            passed++;

            // 3. Duplicate member throws
            try {
                service.addMember(new Member(1, "SomeoneElse"));
                throw new RuntimeException("Duplicate member not detected");
            } catch (DuplicateMemberException ex) {
                passed++;
            }

            // 4. Create membership
            Membership mem1 = service.createMembership(1, "Gold", "2024-02-10", "2024-08-10");
            passed++;

            // 5. Create duplicate membership throws
            try {
                service.createMembership(1, "Gold", "2024-02-10", "2024-08-10");
                throw new RuntimeException("Duplicate membership not detected");
            } catch (InvalidMembershipException ex) {
                passed++;
            }

            // 6. Create membership for unknown member throws
            try {
                service.createMembership(99, "Silver", "2024-04-01", "2024-10-01");
                throw new RuntimeException("Unknown member not detected");
            } catch (MemberNotFoundException ex) {
                passed++;
            }

            // 7. Subscribable interface
            Subscribable sub = new Member(10, "Carol");
            if (!sub.getClass().getInterfaces()[0].getSimpleName().equals("Subscribable")) throw new RuntimeException("Interface missing");
            passed++;

            // 8. Membership details happy
            if (!mem1.getType().equals("Gold")) throw new RuntimeException("Membership wrong");
            passed++;

            // 9. Remove member happy
            service.removeMember(2);
            try {
                service.createMembership(2, "Silver", "2024-02-10", "2024-08-10");
                throw new RuntimeException("Membership for removed member allowed");
            } catch (MemberNotFoundException ex) {
                passed++;
            }

            // 10. Remove membership happy
            service.removeMembership(1);
            try {
                service.createMembership(1, "Gold", "2024-02-10", "2024-08-10");
                // Must succeed after removal
                passed++;
            } catch (InvalidMembershipException ex) {
                throw new RuntimeException("Membership creation not allowed after removal");
            }

            // 11. Remove unknown member throws
            try {
                service.removeMember(99);
                throw new RuntimeException("Remove unknown member not detected");
            } catch (MemberNotFoundException ex) {
                passed++;
            }

            // 12. Null member throws
            try {
                service.addMember(null);
                throw new RuntimeException("Null member not detected");
            } catch (NullPointerException ex) {
                passed++;
            }

            // 13. Null type throws
            try {
                service.createMembership(1, null, "2024-02-10", "2024-08-10");
                throw new RuntimeException("Null membership type not detected");
            } catch (NullPointerException ex) {
                passed++;
            }

            // 14. Defensive: add many members
            for (int i = 100; i < 120; i++)
                service.addMember(new Member(i, "Member"+i));
            passed++;

            // 15. Defensive: many memberships
            for (int i = 100; i < 110; i++)
                service.createMembership(i, "Bronze", "2025-01-01", "2025-12-31");
            passed++;

            // 16. Defensive: invalid dates
            try {
                service.createMembership(1, "Gold", "bad-date", "2024-08-10");
                throw new RuntimeException("Invalid start date not detected");
            } catch (InvalidMembershipException ex) {
                passed++;
            }

            // 17. Remove membership for unknown member throws
            try {
                service.removeMembership(99);
                throw new RuntimeException("Remove membership unknown member not detected");
            } catch (MemberNotFoundException ex) {
                passed++;
            }

            // 18. Defensive: membership boundaries
            try {
                service.createMembership(1, "", "2024-02-10", "2024-08-10");
                throw new RuntimeException("Empty membership type not detected");
            } catch (InvalidMembershipException ex) {
                passed++;
            }

            // 19. Defensive: remove all members
            for (int i = 100; i < 120; i++)
                service.removeMember(i);
            passed++;

            // 20. Defensive: create membership for removed member throws
            try {
                service.createMembership(110, "Bronze", "2025-01-01", "2025-12-31");
                throw new RuntimeException("Membership for removed member allowed");
            } catch (MemberNotFoundException ex) {
                passed++;
            }

            // 21. Defensive: add large membership types
            for (int i = 1000; i < 1050; i++)
                service.createMembership(1, "MegaType"+i, "2024-02-10", "2024-08-10");
            passed++;

            // 22. Remove memberships in bulk
            for (int i = 1000; i < 1050; i++)
                service.removeMembership(1);
            passed++;

            System.out.println("ALL TESTS PASSED");
        } catch (RuntimeException ex) {
            System.out.println("FAILED TESTS: " + (total - passed) + " / " + total);
            throw ex;
        }
    }
}