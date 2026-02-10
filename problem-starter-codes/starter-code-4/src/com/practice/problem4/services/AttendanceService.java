package com.practice.problem4.services;

import com.practice.problem4.models.*;
import com.practice.problem4.exceptions.*;

/**
 * Provides attendance tracking operations.
 */
public class AttendanceService {
    /**
     * Construct service.
     */
    public AttendanceService() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Add a student.
     * @param student student to add
     */
    public void addStudent(Student student) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Remove a student.
     * @param studentId student id
     */
    public void removeStudent(int studentId) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Mark attendance for student and date.
     * @param studentId student id
     * @param date attendance date
     */
    public void markAttendance(int studentId, String date) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Remove an attendance record.
     * @param studentId student id
     * @param date attendance date
     */
    public void removeAttendanceRecord(int studentId, String date) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Get attendance record by student and date.
     * @param studentId student id
     * @param date attendance date
     * @return attendance record
     */
    public AttendanceRecord getAttendanceRecord(int studentId, String date) {
        throw new UnsupportedOperationException("TODO");
    }
}