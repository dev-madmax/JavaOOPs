package com.practice.problem4.evaluator;

import com.practice.problem4.services.*;
import com.practice.problem4.models.*;
import com.practice.problem4.exceptions.*;

/**
 * 🔒 LOCKED -- Students must not edit this file!
 *
 * Evaluates implementations for Classroom Attendance Tracker.
 * Run via Main.java.
 */
public class Evaluator {
    public static void run() {
        int passed = 0;
        int total = 22;

        try {
            AttendanceService service = new AttendanceService();

            // 1. Add student
            Student s1 = new Student(1, "Alice");
            service.addStudent(s1);
            passed++;

            // 2. Add another student
            Student s2 = new Student(2, "Bob");
            service.addStudent(s2);
            passed++;

            // 3. Duplicate student throws
            try {
                service.addStudent(new Student(1, "SomeoneElse"));
                throw new RuntimeException("Duplicate student not detected");
            } catch (RuntimeException ex) {
                passed++;
            }

            // 4. Mark attendance for Alice
            service.markAttendance(1, "2024-02-15");
            passed++;

            // 5. Mark attendance for Bob
            service.markAttendance(2, "2024-02-15");
            passed++;

            // 6. Mark duplicate attendance throws
            try {
                service.markAttendance(1, "2024-02-15");
                throw new RuntimeException("Duplicate attendance not detected");
            } catch (DuplicateAttendanceException ex) {
                passed++;
            }

            // 7. Mark attendance with unknown student throws
            try {
                service.markAttendance(99, "2024-02-15");
                throw new RuntimeException("Unknown student not detected");
            } catch (StudentNotFoundException ex) {
                passed++;
            }

            // 8. Mark attendance with invalid date throws
            try {
                service.markAttendance(1, "invalid-date");
                throw new RuntimeException("Invalid date not detected");
            } catch (InvalidDateException ex) {
                passed++;
            }

            // 9. Get attendance record (happy)
            AttendanceRecord rec = service.getAttendanceRecord(1, "2024-02-15");
            if (rec.getStudentId() != 1) throw new RuntimeException("Attendance record wrong");
            passed++;

            // 10. Get attendance record for non-attended date throws
            try {
                service.getAttendanceRecord(1, "2022-01-01");
                throw new RuntimeException("No attendance record not detected");
            } catch (RuntimeException ex) {
                passed++;
            }

            // 11. Remove student
            service.removeStudent(2);
            try {
                service.markAttendance(2, "2024-02-16");
                throw new RuntimeException("Attendance for removed student allowed");
            } catch (StudentNotFoundException ex) {
                passed++;
            }

            // 12. Null student throws
            try {
                service.addStudent(null);
                throw new RuntimeException("Null student not detected");
            } catch (NullPointerException ex) {
                passed++;
            }

            // 13. Null date throws
            try {
                service.markAttendance(1, null);
                throw new RuntimeException("Null date not detected");
            } catch (NullPointerException ex) {
                passed++;
            }

            // 14. Attendable interface
            Attendable a = new Student(10, "Carol");
            if (!a.getClass().getInterfaces()[0].getSimpleName().equals("Attendable")) throw new RuntimeException("Interface missing");
            passed++;

            // 15. Defensive: empty attendance allowed
            AttendanceRecord rec2 = new AttendanceRecord(10, "2024-02-18");
            if (!rec2.getDate().equals("2024-02-18")) throw new RuntimeException("Wrong date");
            passed++;

            // 16. Defensive: multiple attendances
            for (int i = 100; i < 110; i++)
                service.addStudent(new Student(i, "Student"+i));
            for (int i = 100; i < 110; i++)
                service.markAttendance(i, "2025-02-15");
            passed++;

            // 17. Delete attendance record throws (untracked)
            try {
                service.removeAttendanceRecord(1, "2022-03-01");
                throw new RuntimeException("Remove non-existent attendance not detected");
            } catch (RuntimeException ex) {
                passed++;
            }

            // 18. Remove attendance
            service.removeAttendanceRecord(1, "2024-02-15");
            try {
                service.getAttendanceRecord(1, "2024-02-15");
                throw new RuntimeException("Attendance not removed");
            } catch (RuntimeException ex) {
                passed++;
            }

            // 19. Mark attendance boundary dates
            service.markAttendance(1, "2022-02-15");
            service.markAttendance(1, "2025-12-15");
            passed++;

            // 20. Defensive: add many students
            for(int i = 200; i < 220; i++)
                service.addStudent(new Student(i, "MegaStudent"+i));
            passed++;

            // 21. Defensive: mark many attendances
            for(int i = 200; i < 220; i++)
                service.markAttendance(i, "2026-02-10");
            passed++;

            // 22. Remove student with attendances
            service.removeStudent(100);
            try {
                service.getAttendanceRecord(100, "2025-02-15");
                throw new RuntimeException("Attendance for removed student allowed");
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