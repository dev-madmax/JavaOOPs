# Problem 6: Animal Shelter Management

## Problem Description
Design an animal shelter management system that categorizes animals. Implement inheritance and polymorphism to handle different types of animals with their specific behaviors.

## Requirements
- Create an abstract `Animal` class with common properties (id, name, age, breed)
- Implement abstract method makeSound()
- Create Dog, Cat, and Bird classes that extend Animal
- Each subclass should have specific properties and behaviors
- Implement polymorphic methods where appropriate
- Override toString() method in all classes

## Starter Code Location
- Main implementation: `src/main/java/Animal.java`, `src/main/java/Dog.java`, `src/main/java/Cat.java`, `src/main/java/Bird.java`
- Test cases: `src/test/java/AnimalTest.java`