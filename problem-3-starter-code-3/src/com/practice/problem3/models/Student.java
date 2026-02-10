package com.practice.problem3.models;

/**
 * Represents a student with ID, name, and email.
 */
public class Student {
    private String id;
    private String name;
    private String email;

    /**
     * Creates a new student with the specified details.
     *
     * @param id The unique student ID
     * @param name The name of the student
     * @param email The email address of the student
     * @throws IllegalArgumentException if the email format is invalid
     */
    public Student(String id, String name, String email) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Returns the student ID.
     *
     * @return the student ID
     */
    public String getId() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Returns the student's name.
     *
     * @return the student's name
     */
    public String getName() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Returns the student's email address.
     *
     * @return the student's email address
     */
    public String getEmail() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Checks if this student is equal to another object.
     * Two students are considered equal if they have the same ID.
     *
     * @param obj The object to compare with
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Returns the hash code of the student.
     * The hash code is based on the student ID.
     *
     * @return the hash code of the student
     */
    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("TODO");
    }
}