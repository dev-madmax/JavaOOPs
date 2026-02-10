package com.practice.problem11.evaluator;

import com.practice.problem11.services.*;
import com.practice.problem11.models.*;
import com.practice.problem11.exceptions.*;

/**
 * 🔒 LOCKED -- Students must not edit this file!
 *
 * Evaluates implementations for Task Management System.
 * Run via Main.java.
 */
public class Evaluator {
    public static void run() {
        int passed = 0;
        int total = 22;

        try {
            TaskService service = new TaskService();

            // 1. Add user
            User u1 = new User(1, "Alice");
            service.addUser(u1);
            passed++;

            // 2. Add another user
            User u2 = new User(2, "Bob");
            service.addUser(u2);
            passed++;

            // 3. Duplicate user throws
            try {
                service.addUser(new User(1, "SomeoneElse"));
                throw new RuntimeException("Duplicate user not detected");
            } catch (RuntimeException ex) {
                passed++;
            }

            // 4. Add task
            Task t1 = new Task(101, "Complete report");
            service.addTask(t1);
            passed++;

            // 5. Add another task
            Task t2 = new Task(102, "Fix bugs");
            service.addTask(t2);
            passed++;

            // 6. Duplicate task throws
            try {
                service.addTask(new Task(101, "Other task"));
                throw new RuntimeException("Duplicate task not detected");
            } catch (RuntimeException ex) {
                passed++;
            }

            // 7. Assign task to user
            Assignment a1 = service.assignTask(1, 101);
            passed++;

            // 8. Assign same task to same user throws InvalidAssignmentException
            try {
                service.assignTask(1, 101);
                throw new RuntimeException("Duplicate assignment not detected");
            } catch (InvalidAssignmentException ex) {
                passed++;
            }

            // 9. Assign task to unknown user throws
            try {
                service.assignTask(99, 101);
                throw new RuntimeException("Unknown user not detected");
            } catch (UserNotFoundException ex) {
                passed++;
            }

            // 10. Assign unknown task throws
            try {
                service.assignTask(1, 999);
                throw new RuntimeException("Unknown task not detected");
            } catch (TaskNotFoundException ex) {
                passed++;
            }

            // 11. Assignable interface
            Assignable assignable = new Task(103, "New Task");
            if (!assignable.getClass().getInterfaces()[0].getSimpleName().equals("Assignable")) throw new RuntimeException("Interface missing");
            passed++;

            // 12. Assignment detail happy
            if (a1.getTaskId() != 101) throw new RuntimeException("Assignment wrong");
            passed++;

            // 13. Remove user happy
            service.removeUser(2);
            try {
                service.assignTask(2, 102);
                throw new RuntimeException("Assignment for removed user allowed");
            } catch (UserNotFoundException ex) {
                passed++;
            }

            // 14. Remove task happy
            service.removeTask(102);
            try {
                service.assignTask(1, 102);
                throw new RuntimeException("Assignment for removed task allowed");
            } catch (TaskNotFoundException ex) {
                passed++;
            }

            // 15. Remove assignment happy
            service.removeAssignment(1, 101);
            try {
                service.assignTask(1, 101);
                // Can reassign after removal
                passed++;
            } catch (InvalidAssignmentException ex) {
                throw new RuntimeException("Assignment not allowed after removal");
            }

            // 16. Null user throws
            try {
                service.addUser(null);
                throw new RuntimeException("Null user not detected");
            } catch (NullPointerException ex) {
                passed++;
            }

            // 17. Null task throws
            try {
                service.addTask(null);
                throw new RuntimeException("Null task not detected");
            } catch (NullPointerException ex) {
                passed++;
            }

            // 18. Null assignment throws
            try {
                service.assignTask(1, 0);
                throw new RuntimeException("Null task id not detected");
            } catch (TaskNotFoundException ex) {
                passed++;
            }

            // 19. Defensive: add many users/tasks
            for (int i = 100; i < 120; i++) {
                service.addUser(new User(i, "User"+i));
                service.addTask(new Task(i, "Task"+i));
                service.assignTask(i, i);
            }
            passed++;

            // 20. Defensive: remove assignments in bulk
            for (int i = 100; i < 120; i++)
                service.removeAssignment(i, i);
            passed++;

            // 21. Defensive: remove user with assignments
            service.removeUser(100);
            try {
                service.assignTask(100, 100);
                throw new RuntimeException("Assignment for removed user allowed");
            } catch (UserNotFoundException ex) {
                passed++;
            }

            // 22. Defensive: add large tasks/users
            for (int i = 1000; i < 1030; i++) {
                service.addUser(new User(i, "BigUser"+i));
                service.addTask(new Task(i, "BigTask"+i));
            }
            passed++;

            System.out.println("ALL TESTS PASSED");
        } catch (RuntimeException ex) {
            System.out.println("FAILED TESTS: " + (total - passed) + " / " + total);
            throw ex;
        }
    }
}