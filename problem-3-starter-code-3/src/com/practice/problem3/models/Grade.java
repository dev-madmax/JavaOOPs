package com.practice.problem3.models;

/**
 * Represents a grade for a student in a specific course.
 */
public class Grade {
    private String studentId;
    private String courseId;
    private String letterGrade;

    /**
     * Creates a new grade record for a student in a course.
     *
     * @param student The student receiving the grade
     * @param course The course in which the grade is received
     * @param letterGrade The letter grade received (e.g., A+, B-, etc.)
     * @throws IllegalArgumentException if the letter grade is invalid
     */
    public Grade(Student student, Course course, String letterGrade) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Returns the ID of the student who received this grade.
     *
     * @return the student ID
     */
    public String getStudentId() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Returns the ID of the course in which this grade was received.
     *
     * @return the course ID
     */
    public String getCourseId() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Returns the letter grade received.
     *
     * @return the letter grade
     */
    public String getLetterGrade() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Returns the numeric equivalent of the letter grade.
     * A+ = 4.0, A = 4.0, A- = 3.7, B+ = 3.3, B = 3.0, B- = 2.7, etc.
     *
     * @return the numeric grade value
     */
    public double getNumericGrade() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Checks if this grade is equal to another object.
     * Two grades are considered equal if they have the same student and course.
     *
     * @param obj The object to compare with
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Returns the hash code of the grade.
     * The hash code is based on the student ID and course ID.
     *
     * @return the hash code of the grade
     */
    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("TODO");
    }
}