## Problem 10: Restaurant Table Reservation System

**Description**  
Manage restaurant table reservations with capacity constraints. Prevent overlapping bookings. *Teaches: Encapsulation of reservation state, Interface abstraction, Composition (Table aggregates Reservations), Date/time logic.*

**OOP Concepts Explicitly Required**  
- ✅ **Encapsulation**: Reservation list private; no direct access  
- ✅ **Abstraction**: `Reservable` interface for bookable entities  
- ✅ **Composition**: `Table` HAS multiple `Reservation` objects  
- ✅ **Helper Class**: `Reservation` as value object with time logic

**Interfaces**  
```java
public interface Reservable {
    boolean isAvailable(LocalDateTime start, int durationMinutes);
    void reserve(LocalDateTime start, int durationMinutes, int partySize) throws TableUnavailableException;
}
```

**Classes**  
- `Table` implements `Reservable`  
  - Fields: `private int tableNumber`, `private int capacity`, `private List<Reservation> reservations`  
- `Reservation`  
  - Fields: `private int partySize`, `private LocalDateTime startTime`, `private int durationMinutes`  
  - Method: `LocalDateTime getEndTime()` – returns `startTime.plusMinutes(durationMinutes)`  
- `Restaurant`  
  - Fields: `private String name`, `private List<Table> tables`

**Constructors**  
- `Table(int tableNumber, int capacity)` – validates `2 <= capacity <= 10`  
- `Reservation(int partySize, LocalDateTime startTime, int durationMinutes)` – validates `partySize > 0`  
- `Restaurant(String name)` – initializes empty table list

**Methods to Implement**  
1. `Restaurant.addTable(Table table)`  
2. `Restaurant.findAvailableTable(int partySize, LocalDateTime time, int duration)` – returns first suitable table  
3. `Table.isAvailable(LocalDateTime start, int duration)` – checks ALL reservations for overlap  
4. `Table.getReservations()` – returns unmodifiable list  
5. `Restaurant.cancelReservation(int tableNumber, LocalDateTime time)` – removes reservation starting at exact time

**Exceptions**  
- `TableUnavailableException extends Exception`  
- `InvalidPartySizeException extends Exception`

**Grading Focus**  
✓ Time overlap logic: reservation occupies `[start, end)` interval  
✓ Capacity validation: `partySize <= table.capacity`  
✓ Unmodifiable collections returned to prevent external modification  
✓ Table selection: smallest suitable table preferred (bonus)

---
