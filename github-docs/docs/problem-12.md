## Problem 12: Flight Booking System

**Description**  
Model airline flights with limited seats. Prevent overbooking. Track passenger assignments. *Teaches: Encapsulation of seat capacity, Interface abstraction, Composition (Flight aggregates Passengers), Validation.*

**OOP Concepts Explicitly Required**  
- ✅ **Encapsulation**: Seat count tracked internally; not directly exposed  
- ✅ **Abstraction**: `BookableFlight` interface defines booking contract  
- ✅ **Composition**: `Flight` HAS multiple `Passenger` objects  
- ✅ **Validation**: Business rules enforced before state change

**Interfaces**  
```java
public interface BookableFlight {
    boolean hasAvailableSeats();
    void bookSeat(Passenger passenger) throws FlightFullException;
    int getRemainingSeats();
}
```

**Classes**  
- `Flight` implements `BookableFlight`  
  - Fields: `private String flightNumber`, `private String origin`, `private String destination`, `private LocalDateTime departureTime`, `private int totalSeats`, `private List<Passenger> passengers`  
- `Passenger`  
  - Fields: `private int id`, `private String name`  
- `Airline`  
  - Fields: `private String name`, `private List<Flight> flights`, `private List<Passenger> registeredPassengers`

**Constructors**  
- `Flight(String flightNumber, String origin, String destination, LocalDateTime departureTime, int totalSeats)` – validates `totalSeats > 0`  
- `Passenger(int id, String name)`  
- `Airline(String name)` – initializes empty collections

**Methods to Implement**  
1. `Airline.addFlight(Flight flight)`  
2. `Airline.registerPassenger(Passenger passenger)`  
3. `Flight.bookSeat(Passenger passenger)` – validates passenger registered + seats available  
4. `Flight.getBookedPassengers()` – returns unmodifiable list  
5. `Airline.findFlights(String origin, String destination, LocalDate date)` – filters by date (extract from LocalDateTime)

**Exceptions**  
- `FlightFullException extends Exception`  
- `PassengerNotRegisteredException extends Exception`

**Grading Focus**  
✓ Seat availability calculated as `totalSeats - passengers.size()`  
✓ Passenger registration validation BEFORE booking  
✓ Date filtering using `departureTime.toLocalDate().equals(date)`  
✓ Unmodifiable collections returned for safety

---
