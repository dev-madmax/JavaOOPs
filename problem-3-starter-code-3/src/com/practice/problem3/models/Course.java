package com.practice.problem3.models;

/**
 * Represents a course with ID, name, and credit hours.
 */
public class Course {
    private String id;
    private String name;
    private int credits;

    /**
     * Creates a new course with the specified details.
     *
     * @param id The unique course ID
     * @param name The name of the course
     * @param credits The number of credit hours for the course
     */
    public Course(String id, String name, int credits) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Returns the course ID.
     *
     * @return the course ID
     */
    public String getId() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Returns the course name.
     *
     * @return the course name
     */
    public String getName() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Returns the number of credit hours for the course.
     *
     * @return the number of credit hours
     */
    public int getCredits() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Checks if this course is equal to another object.
     * Two courses are considered equal if they have the same ID.
     *
     * @param obj The object to compare with
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Returns the hash code of the course.
     * The hash code is based on the course ID.
     *
     * @return the hash code of the course
     */
    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("TODO");
    }
}