## Problem 5: Hotel Room Booking System

**Description**  
Manage hotel rooms with bookings. Prevent double-booking. Room types (`StandardRoom`, `DeluxeRoom`) share booking logic. *Teaches: Inheritance with identical behavior, Interface abstraction, Encapsulation of booking state, Composition.*

**OOP Concepts Explicitly Required**  
- ✅ **Inheritance**: `Room` (abstract) → `StandardRoom`, `DeluxeRoom`  
- ✅ **Abstraction**: `Bookable` interface defines booking contract  
- ✅ **Encapsulation**: Bookings stored privately; accessed via methods only  
- ✅ **Composition**: `Hotel` aggregates `Room` objects

**Interfaces**  
```java
public interface Bookable {
    boolean isAvailable(LocalDate startDate, LocalDate endDate);
    void book(LocalDate startDate, LocalDate endDate) throws RoomNotAvailableException;
}
```

**Classes**  
- `Room` (abstract) implements `Bookable`  
  - Fields: `protected int roomNumber`, `protected List<Booking> bookings`  
  - Constructor: `Room(int roomNumber)`  
- `StandardRoom extends Room`  
- `DeluxeRoom extends Room` (has balcony – no behavioral difference for booking)  
- `Booking` (helper class)  
  - Fields: `private LocalDate startDate`, `private LocalDate endDate`  
- `Hotel`  
  - Fields: `private String name`, `private List<Room> rooms`

**Constructors**  
- `StandardRoom(int roomNumber)` – calls `super(roomNumber)`  
- `DeluxeRoom(int roomNumber)` – calls `super(roomNumber)`  
- `Hotel(String name)` – initializes empty room list

**Methods to Implement**  
1. `Hotel.addRoom(Room room)`  
2. `Hotel.bookRoom(int roomNumber, LocalDate start, LocalDate end)` – finds room and books  
3. `Room.isAvailable(LocalDate start, LocalDate end)` – checks ALL existing bookings for overlap  
4. `Hotel.getAvailableRooms(LocalDate date)` – returns rooms free on that date  
5. `Room.getBookings()` – returns unmodifiable list (`Collections.unmodifiableList(bookings)`)

**Exceptions**  
- `RoomNotAvailableException extends Exception`

**Grading Focus**  
✓ Date overlap logic: `[start1, end1)` overlaps `[start2, end2)` if `start1 < end2 && start2 < end1`  
✓ Abstract parent with concrete identical behavior in subclasses  
✓ Unmodifiable collections returned to prevent external modification  
✓ Validation before booking (null checks, date order)

---
