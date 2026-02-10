package com.practice.problem4.evaluator;

import com.practice.problem4.models.Task;
import com.practice.problem4.models.TaskStatus;
import com.practice.problem4.exceptions.InvalidTaskException;

public class Evaluator {
    public static void run() {
        // Test basic functionality
        Task task = new Task("T001", "Complete project", "Implement all features", TaskStatus.PENDING);
        
        // Test constructor and getters
        if (!task.getId().equals("T001")) {
            throw new RuntimeException("Task ID getter failed");
        }
        if (!task.getTitle().equals("Complete project")) {
            throw new RuntimeException("Task title getter failed");
        }
        if (!task.getDescription().equals("Implement all features")) {
            throw new RuntimeException("Task description getter failed");
        }
        if (task.getStatus() != TaskStatus.PENDING) {
            throw new RuntimeException("Task status getter failed");
        }
        if (task.isCompleted()) {
            throw new RuntimeException("Newly created task should not be completed");
        }
        
        // Test updating task status
        task.updateStatus(TaskStatus.IN_PROGRESS);
        if (task.getStatus() != TaskStatus.IN_PROGRESS) {
            throw new RuntimeException("Task status update failed");
        }
        if (task.isCompleted()) {
            throw new RuntimeException("Task with IN_PROGRESS status should not be completed");
        }
        
        // Test completing task
        task.updateStatus(TaskStatus.COMPLETED);
        if (task.getStatus() != TaskStatus.COMPLETED) {
            throw new RuntimeException("Task completion failed");
        }
        if (!task.isCompleted()) {
            throw new RuntimeException("Completed task should return true for isCompleted()");
        }
        
        // Test setting back to pending after completion
        task.updateStatus(TaskStatus.PENDING);
        if (task.getStatus() != TaskStatus.PENDING) {
            throw new RuntimeException("Setting status to PENDING after completion failed");
        }
        if (task.isCompleted()) {
            throw new RuntimeException("Task with PENDING status should not be completed");
        }
        
        // Test invalid task ID
        boolean invalidIdThrown = false;
        try {
            Task invalidTask = new Task("", "Title", "Description", TaskStatus.PENDING);
        } catch (IllegalArgumentException e) {
            invalidIdThrown = true;
        } catch (Exception e) {
            throw new RuntimeException("Wrong exception type thrown for invalid ID: " + e.getMessage());
        }
        if (!invalidIdThrown) {
            throw new RuntimeException("Should throw IllegalArgumentException for empty ID");
        }
        
        // Test invalid title
        boolean invalidTitleThrown = false;
        try {
            Task invalidTask = new Task("T002", "", "Description", TaskStatus.PENDING);
        } catch (IllegalArgumentException e) {
            invalidTitleThrown = true;
        } catch (Exception e) {
            throw new RuntimeException("Wrong exception type thrown for invalid title: " + e.getMessage());
        }
        if (!invalidTitleThrown) {
            throw new RuntimeException("Should throw IllegalArgumentException for empty title");
        }
        
        // Test null values
        boolean nullIdThrown = false;
        try {
            Task nullTask = new Task(null, "Title", "Description", TaskStatus.PENDING);
        } catch (IllegalArgumentException e) {
            nullIdThrown = true;
        } catch (Exception e) {
            throw new RuntimeException("Wrong exception type thrown for null ID: " + e.getMessage());
        }
        if (!nullIdThrown) {
            throw new RuntimeException("Should throw IllegalArgumentException for null ID");
        }
        
        boolean nullTitleThrown = false;
        try {
            Task nullTask = new Task("T003", null, "Description", TaskStatus.PENDING);
        } catch (IllegalArgumentException e) {
            nullTitleThrown = true;
        } catch (Exception e) {
            throw new RuntimeException("Wrong exception type thrown for null title: " + e.getMessage());
        }
        if (!nullTitleThrown) {
            throw new RuntimeException("Should throw IllegalArgumentException for null title");
        }
        
        boolean nullDescriptionThrown = false;
        try {
            Task nullTask = new Task("T004", "Title", null, TaskStatus.PENDING);
        } catch (IllegalArgumentException e) {
            nullDescriptionThrown = true;
        } catch (Exception e) {
            throw new RuntimeException("Wrong exception type thrown for null description: " + e.getMessage());
        }
        if (!nullDescriptionThrown) {
            throw new RuntimeException("Should throw IllegalArgumentException for null description");
        }
        
        // Test equals/hashCode
        Task task1 = new Task("T100", "Task 1", "Description 1", TaskStatus.PENDING);
        Task task2 = new Task("T100", "Task 2", "Description 2", TaskStatus.COMPLETED);  // Same ID, different other fields
        Task task3 = new Task("T200", "Task 1", "Description 1", TaskStatus.PENDING);   // Different ID, same other fields
        
        if (!task1.equals(task2)) {
            throw new RuntimeException("Tasks with same ID should be equal");
        }
        if (task1.equals(task3)) {
            throw new RuntimeException("Tasks with different IDs should not be equal");
        }
        if (task1.hashCode() != task2.hashCode()) {
            throw new RuntimeException("Equal tasks should have same hash code");
        }
        
        // Test all status transitions
        Task statusTestTask = new Task("T005", "Status Test", "Testing all statuses", TaskStatus.PENDING);
        
        // PENDING -> IN_PROGRESS
        statusTestTask.updateStatus(TaskStatus.IN_PROGRESS);
        if (statusTestTask.getStatus() != TaskStatus.IN_PROGRESS) {
            throw new RuntimeException("PENDING to IN_PROGRESS transition failed");
        }
        
        // IN_PROGRESS -> COMPLETED
        statusTestTask.updateStatus(TaskStatus.COMPLETED);
        if (statusTestTask.getStatus() != TaskStatus.COMPLETED) {
            throw new RuntimeException("IN_PROGRESS to COMPLETED transition failed");
        }
        
        // COMPLETED -> PENDING
        statusTestTask.updateStatus(TaskStatus.PENDING);
        if (statusTestTask.getStatus() != TaskStatus.PENDING) {
            throw new RuntimeException("COMPLETED to PENDING transition failed");
        }
        
        // PENDING -> COMPLETED (direct transition)
        statusTestTask.updateStatus(TaskStatus.COMPLETED);
        if (statusTestTask.getStatus() != TaskStatus.COMPLETED) {
            throw new RuntimeException("PENDING to COMPLETED direct transition failed");
        }
        
        // Test task completion detection
        Task completedTask = new Task("T006", "Completed Task", "This task is completed", TaskStatus.COMPLETED);
        if (!completedTask.isCompleted()) {
            throw new RuntimeException("Task with COMPLETED status should return true for isCompleted()");
        }
        
        Task pendingTask = new Task("T007", "Pending Task", "This task is pending", TaskStatus.PENDING);
        if (pendingTask.isCompleted()) {
            throw new RuntimeException("Task with PENDING status should return false for isCompleted()");
        }
        
        // Test description with special characters
        Task specialCharTask = new Task("T008", "Special Chars", "Description with spaces, numbers 123, and symbols !@#$%^&*()", TaskStatus.IN_PROGRESS);
        if (!specialCharTask.getDescription().equals("Description with spaces, numbers 123, and symbols !@#$%^&*()")) {
            throw new RuntimeException("Description with special characters not preserved");
        }
        
        System.out.println("PASS");
    }
}