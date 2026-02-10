package com.practice.problem4.models;

/**
 * Represents a task with ID, title, description, and status.
 */
public class Task {
    private String id;
    private String title;
    private String description;
    private TaskStatus status;

    /**
     * Creates a new task with the specified details.
     *
     * @param id The unique task ID
     * @param title The title of the task
     * @param description The description of the task
     * @param status The initial status of the task
     * @throws IllegalArgumentException if any parameter is null or if id/title is empty
     */
    public Task(String id, String title, String description, TaskStatus status) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Returns the task ID.
     *
     * @return the task ID
     */
    public String getId() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Returns the task title.
     *
     * @return the task title
     */
    public String getTitle() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Returns the task description.
     *
     * @return the task description
     */
    public String getDescription() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Returns the current status of the task.
     *
     * @return the current status
     */
    public TaskStatus getStatus() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Updates the status of the task.
     *
     * @param status The new status for the task
     */
    public void updateStatus(TaskStatus status) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Checks if the task is completed.
     *
     * @return true if the task status is COMPLETED, false otherwise
     */
    public boolean isCompleted() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Checks if this task is equal to another object.
     * Two tasks are considered equal if they have the same ID.
     *
     * @param obj The object to compare with
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Returns the hash code of the task.
     * The hash code is based on the task ID.
     *
     * @return the hash code of the task
     */
    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("TODO");
    }
}