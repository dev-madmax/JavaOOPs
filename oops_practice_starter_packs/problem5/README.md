# Problem 5: Library Management System

## Problem Description
Design a library management system that handles different types of publications. Implement inheritance and polymorphism to manage books, magazines, and newspapers with their specific attributes.

## Requirements
- Create an abstract `Publication` class with common properties (id, title, author/publisher, publicationDate)
- Implement abstract method getPublicationType()
- Create Book, Magazine, and Newspaper classes that extend Publication
- Each subclass should have specific properties (Book: ISBN, pages; Magazine: issueNumber; Newspaper: circulation)
- Override toString() method in all classes

## Starter Code Location
- Main implementation: `src/main/java/Publication.java`, `src/main/java/Book.java`, `src/main/java/Magazine.java`, `src/main/java/Newspaper.java`
- Test cases: `src/test/java/PublicationTest.java`