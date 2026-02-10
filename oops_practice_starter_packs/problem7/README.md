# Problem 7: University Course Management System

## Problem Description
Design a university course management system that handles different types of courses. Implement inheritance and polymorphism to manage undergraduate, graduate, and continuing education courses with their specific requirements.

## Requirements
- Create an abstract `Course` class with common properties (courseId, courseName, credits, instructor)
- Implement abstract method getCourseLevel()
- Create UndergraduateCourse, GraduateCourse, and ContinuingEducationCourse classes that extend Course
- Each subclass should have specific properties (e.g., prerequisites for graduate courses, continuing education units for CE courses)
- Override toString() method in all classes

## Starter Code Location
- Main implementation: `src/main/java/Course.java`, `src/main/java/UndergraduateCourse.java`, `src/main/java/GraduateCourse.java`, `src/main/java/ContinuingEducationCourse.java`
- Test cases: `src/test/java/CourseTest.java`