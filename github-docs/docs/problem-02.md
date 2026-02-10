## Problem 2: Parking Lot Manager

**Description**  
Model a parking lot with capacity limits. Different vehicle types (`Car`, `Motorcycle`) inherit from abstract `Vehicle`. *Teaches: Inheritance hierarchy, Polymorphic behavior, Interface abstraction, Encapsulation of capacity.*

**OOP Concepts Explicitly Required**  
- ✅ **Inheritance**: `Vehicle` (abstract) → `Car`, `Motorcycle` (concrete)  
- ✅ **Polymorphism**: `getSpaceRequired()` overridden per vehicle type  
- ✅ **Abstraction**: `Parkable` interface for parking operations  
- ✅ **Encapsulation**: `ParkingLot` hides internal vehicle collection

**Interfaces**  
```java
public interface Parkable {
    int getSpaceRequired();
    String getLicensePlate();
}
```

**Classes**  
- `Vehicle` (abstract) implements `Parkable`  
  - Fields: `protected String licensePlate`  
  - Constructor: `Vehicle(String licensePlate)`  
- `Car extends Vehicle`  
  - `getSpaceRequired()` returns `1`  
- `Motorcycle extends Vehicle`  
  - `getSpaceRequired()` returns `1` (simplified)  
- `ParkingLot`  
  - Fields: `private int totalSpaces`, `private int occupiedSpaces`, `private List<Vehicle> parkedVehicles`

**Constructors**  
- `Car(String licensePlate)` – calls `super(licensePlate)`  
- `Motorcycle(String licensePlate)` – calls `super(licensePlate)`  
- `ParkingLot(int totalSpaces)` – validates `totalSpaces > 0`

**Methods to Implement**  
1. `ParkingLot.parkVehicle(Vehicle vehicle)` – checks capacity before adding  
2. `ParkingLot.removeVehicle(String licensePlate)` – finds and removes vehicle  
3. `ParkingLot.getAvailableSpaces()` – returns `totalSpaces - occupiedSpaces`  
4. `ParkingLot.isFull()` – returns `occupiedSpaces >= totalSpaces`  
5. `Vehicle.getLicensePlate()` – returns license plate (implemented in abstract class)

**Exceptions**  
- `ParkingFullException extends Exception`

**Grading Focus**  
✓ Abstract class with protected field + concrete subclasses  
✓ Polymorphic method calls (`vehicle.getSpaceRequired()`)  
✓ Capacity calculation without exposing internal state  
✓ Proper vehicle removal (find by license plate, update occupancy)

---
