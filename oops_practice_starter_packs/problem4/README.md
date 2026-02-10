# Problem 4: Vehicle Rental System

## Problem Description
Design a vehicle rental system that manages different types of vehicles. Implement inheritance and polymorphism to handle cars, motorcycles, and trucks with different rental rates.

## Requirements
- Create an abstract `Vehicle` class with common properties (vehicleId, model, brand, rentalRate)
- Implement abstract method calculateRentalCost(int days)
- Create Car, Motorcycle, and Truck classes that extend Vehicle with specific properties
- Implement calculateRentalCost() differently for each vehicle type (e.g., trucks might have additional fees)
- Override toString() method in all classes

## Starter Code Location
- Main implementation: `src/main/java/Vehicle.java`, `src/main/java/Car.java`, `src/main/java/Motorcycle.java`, `src/main/java/Truck.java`
- Test cases: `src/test/java/VehicleTest.java`