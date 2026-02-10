# Problem 3: Shape Hierarchy

## Problem Description
Design a shape hierarchy with an abstract base class and several concrete implementations. Implement polymorphism by having each shape calculate its own area and perimeter.

## Requirements
- Create an abstract `Shape` class with abstract methods calculateArea() and calculatePerimeter()
- Create concrete classes: Circle, Rectangle, Triangle
- Each concrete class should implement the abstract methods
- Implement proper constructors and getters/setters
- Override toString() method in all classes

## Starter Code Location
- Main implementation: `src/main/java/Shape.java`, `src/main/java/Circle.java`, `src/main/java/Rectangle.java`, `src/main/java/Triangle.java`
- Test cases: `src/test/java/ShapeTest.java`