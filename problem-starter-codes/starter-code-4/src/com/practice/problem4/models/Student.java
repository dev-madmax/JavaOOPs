package com.practice.problem4.models;

import com.practice.problem4.interfaces.Attendable;

/**
 * Represents a student.
 */
public class Student implements Attendable {
    /**
     * Constructs a student with id and name.
     * @param studentId student id
     * @param name student name
     */
    public Student(int studentId, String name) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Get student id.
     * @return studentId
     */
    public int getStudentId() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Get student name.
     * @return name
     */
    public String getName() {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public int getAttendanceId() {
        throw new UnsupportedOperationException("TODO");
    }
}