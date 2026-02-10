## Problem 11: Task Management System

**Description**  
Manage tasks with priorities and deadlines. Track completion status and overdue items. *Teaches: Encapsulation of state, Enum usage, Interface abstraction, Composition (TaskList aggregates Tasks).*

**OOP Concepts Explicitly Required**  
- ✅ **Encapsulation**: Completion state + deadline private  
- ✅ **Abstraction**: `TaskItem` interface for task contract  
- ✅ **Enum**: `Priority` enum (HIGH, MEDIUM, LOW)  
- ✅ **Composition**: `TaskList` HAS multiple `Task` objects

**Interfaces**  
```java
public interface TaskItem {
    String getDescription();
    boolean isCompleted();
    LocalDate getDeadline();
}
```

**Classes**  
- `Priority` enum: `HIGH`, `MEDIUM`, `LOW`  
- `Task` implements `TaskItem`  
  - Fields: `private String description`, `private Priority priority`, `private LocalDate deadline`, `private boolean completed`, `private LocalDateTime completionTime`  
- `TaskList`  
  - Fields: `private String name`, `private List<Task> tasks`  
- `TaskManager`  
  - Fields: `private String userName`, `private List<TaskList> lists`

**Constructors**  
- `Task(String description, Priority priority, LocalDate deadline)` – validates `deadline.isAfter(LocalDate.now())`  
- `TaskList(String name)`  
- `TaskManager(String userName)` – initializes empty list collection

**Methods to Implement**  
1. `TaskList.addTask(Task task)`  
2. `Task.complete()` – sets `completed = true` and `completionTime = LocalDateTime.now()`  
3. `TaskList.getOverdueTasks()` – returns incomplete tasks with `deadline.isBefore(LocalDate.now())`  
4. `TaskList.getTasksByPriority(Priority priority)` – returns filtered list  
5. `TaskManager.createTaskList(String name)`

**Exceptions**  
- `PastDeadlineException extends Exception`

**Grading Focus**  
✓ Deadline validation in constructor using `LocalDate.now()`  
✓ Completion state management (boolean + timestamp)  
✓ Filtering without modifying original list (return new ArrayList)  
✓ Proper enum usage (no String literals for priorities)

---
