package com.practice.problem11.models;

import com.practice.problem11.interfaces.Assignable;

/**
 * Represents a task.
 */
public class Task implements Assignable {
    /**
     * Construct a task with id and description.
     * @param taskId task id
     * @param description task description
     */
    public Task(int taskId, String description) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Get task id.
     */
    @Override
    public int getTaskId() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Get task description.
     */
    public String getDescription() {
        throw new UnsupportedOperationException("TODO");
    }
}