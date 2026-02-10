package com.practice.problem3.evaluator;

import com.practice.problem3.models.Student;
import com.practice.problem3.models.Course;
import com.practice.problem3.models.Grade;
import com.practice.problem3.exceptions.DuplicateEntityException;
import com.practice.problem3.exceptions.EntityNotFoundException;

public class Evaluator {
    public static void run() {
        // Test basic functionality
        Student student = new Student("S001", "John Doe", "john.doe@email.com");
        Course course = new Course("CS101", "Introduction to Programming", 3);
        
        // Test constructor and getters for Student
        if (!student.getId().equals("S001")) {
            throw new RuntimeException("Student ID getter failed");
        }
        if (!student.getName().equals("John Doe")) {
            throw new RuntimeException("Student name getter failed");
        }
        if (!student.getEmail().equals("john.doe@email.com")) {
            throw new RuntimeException("Student email getter failed");
        }
        
        // Test constructor and getters for Course
        if (!course.getId().equals("CS101")) {
            throw new RuntimeException("Course ID getter failed");
        }
        if (!course.getName().equals("Introduction to Programming")) {
            throw new RuntimeException("Course name getter failed");
        }
        if (course.getCredits() != 3) {
            throw new RuntimeException("Course credits getter failed");
        }
        
        // Test grade creation
        Grade grade = new Grade(student, course, "A+");
        if (!grade.getStudentId().equals("S001")) {
            throw new RuntimeException("Grade student ID getter failed");
        }
        if (!grade.getCourseId().equals("CS101")) {
            throw new RuntimeException("Grade course ID getter failed");
        }
        if (!grade.getLetterGrade().equals("A+")) {
            throw new RuntimeException("Grade letter grade getter failed");
        }
        
        // Test grade points calculation
        if (Math.abs(grade.getNumericGrade() - 4.0) > 0.001) {
            throw new RuntimeException("Grade numeric conversion failed for A+");
        }
        
        // Test different letter grades
        Grade bPlus = new Grade(student, new Course("CS102", "Data Structures", 4), "B+");
        if (Math.abs(bPlus.getNumericGrade() - 3.3) > 0.001) {
            throw new RuntimeException("Grade numeric conversion failed for B+");
        }
        
        Grade cMinus = new Grade(student, new Course("CS103", "Algorithms", 3), "C-");
        if (Math.abs(cMinus.getNumericGrade() - 1.7) > 0.001) {
            throw new RuntimeException("Grade numeric conversion failed for C-");
        }
        
        Grade fGrade = new Grade(student, new Course("CS104", "Database Systems", 3), "F");
        if (Math.abs(fGrade.getNumericGrade() - 0.0) > 0.001) {
            throw new RuntimeException("Grade numeric conversion failed for F");
        }
        
        // Test invalid grade
        boolean invalidGradeThrown = false;
        try {
            Grade invalid = new Grade(student, new Course("CS105", "Invalid Grade", 2), "X");
        } catch (IllegalArgumentException e) {
            invalidGradeThrown = true;
        } catch (Exception e) {
            throw new RuntimeException("Wrong exception type thrown for invalid grade: " + e.getMessage());
        }
        if (!invalidGradeThrown) {
            throw new RuntimeException("Should throw IllegalArgumentException for invalid grade");
        }
        
        // Test student equals/hashCode
        Student student2 = new Student("S001", "Jane Smith", "jane.smith@email.com");  // Same ID, different name/email
        if (!student.equals(student2)) {
            throw new RuntimeException("Students with same ID should be equal");
        }
        if (student.hashCode() != student2.hashCode()) {
            throw new RuntimeException("Equal students should have same hash code");
        }
        
        // Test course equals/hashCode
        Course course2 = new Course("CS101", "Different Name", 5);  // Same ID, different name/credits
        if (!course.equals(course2)) {
            throw new RuntimeException("Courses with same ID should be equal");
        }
        if (course.hashCode() != course2.hashCode()) {
            throw new RuntimeException("Equal courses should have same hash code");
        }
        
        // Test grade equals/hashCode
        Grade grade2 = new Grade(student, course, "A");  // Same student and course, different grade
        if (!grade.equals(grade2)) {
            throw new RuntimeException("Grades with same student and course should be equal");
        }
        if (grade.hashCode() != grade2.hashCode()) {
            throw new RuntimeException("Equal grades should have same hash code");
        }
        
        // Test email validation in student
        boolean invalidEmailThrown = false;
        try {
            Student invalidStudent = new Student("S002", "Invalid Email", "not-an-email");
        } catch (IllegalArgumentException e) {
            invalidEmailThrown = true;
        } catch (Exception e) {
            throw new RuntimeException("Wrong exception type thrown for invalid email: " + e.getMessage());
        }
        if (!invalidEmailThrown) {
            throw new RuntimeException("Should throw IllegalArgumentException for invalid email");
        }
        
        // Test valid email formats
        try {
            Student validStudent1 = new Student("S003", "Valid Email 1", "test@example.com");
            Student validStudent2 = new Student("S004", "Valid Email 2", "user.name+tag@domain.co.uk");
            Student validStudent3 = new Student("S005", "Valid Email 3", "user_name@sub.domain.org");
        } catch (Exception e) {
            throw new RuntimeException("Valid email formats should not throw exception: " + e.getMessage());
        }
        
        // Test letter grade validation
        String[] validGrades = {"A+", "A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "D-", "F"};
        for (String gradeStr : validGrades) {
            try {
                Grade validGrade = new Grade(student, new Course("CS999", "Test Course", 1), gradeStr);
            } catch (Exception e) {
                throw new RuntimeException("Valid grade '" + gradeStr + "' should not throw exception: " + e.getMessage());
            }
        }
        
        // Test invalid letter grades
        String[] invalidGrades = {"G", "E", "Z", "", "AA", "A++", "B++", "a+", "A ", " A+"};
        for (String gradeStr : invalidGrades) {
            boolean thrown = false;
            try {
                Grade invalidGrade = new Grade(student, new Course("CS998", "Test Course", 1), gradeStr);
            } catch (IllegalArgumentException e) {
                thrown = true;
            } catch (Exception e) {
                throw new RuntimeException("Wrong exception type thrown for invalid grade '" + gradeStr + "': " + e.getMessage());
            }
            if (!thrown) {
                throw new RuntimeException("Should throw IllegalArgumentException for invalid grade: " + gradeStr);
            }
        }
        
        System.out.println("PASS");
    }
}