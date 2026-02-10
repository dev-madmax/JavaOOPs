## Problem 4: Classroom Attendance Tracker

**Description**  
Track student attendance across multiple class sessions. Calculate attendance percentages. *Teaches: Composition (Course → Sessions → Students), Encapsulation of attendance maps, Interface abstraction.*

**OOP Concepts Explicitly Required**  
- ✅ **Composition**: `Course` HAS `ClassSession` objects; `ClassSession` HAS attendance records  
- ✅ **Encapsulation**: Attendance stored in private `Map<String, Boolean>`  
- ✅ **Abstraction**: `Attendee` interface for student representation  
- ✅ **Aggregation**: Students exist independently of sessions

**Interfaces**  
```java
public interface Attendee {
    String getId();
    String getName();
}
```

**Classes**  
- `Student` implements `Attendee`  
  - Fields: `private String id`, `private String name`  
- `ClassSession`  
  - Fields: `private LocalDate date`, `private Map<String, Boolean> attendance` (key=studentId, value=present)  
- `Course`  
  - Fields: `private String courseId`, `private String courseName`, `private List<Student> roster`, `private List<ClassSession> sessions`

**Constructors**  
- `Student(String id, String name)`  
- `ClassSession(LocalDate date)` – initializes empty attendance map  
- `Course(String courseId, String courseName)` – initializes empty collections

**Methods to Implement**  
1. `Course.enrollStudent(Student student)` – adds to roster if not duplicate  
2. `Course.addSession(ClassSession session)`  
3. `ClassSession.markPresent(String studentId)` – throws if student not in course roster  
4. `Student.getAttendancePercentage(Course course)` – calculates `(present sessions / total sessions) * 100`  
5. `Course.getAbsentStudents(LocalDate date)` – returns students NOT marked present for that date

**Exceptions**  
- `StudentNotEnrolledException extends Exception`

**Grading Focus**  
✓ Bidirectional validation: Session checks against Course roster  
✓ Percentage calculation rounded to 2 decimal places  
✓ No direct access to attendance map (use methods only)  
✓ Proper date handling with `java.time.LocalDate`

---
