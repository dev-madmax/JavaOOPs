## Problem 14: Movie Theater Ticketing System

**Description**  
Manage cinema showtimes with seat reservations. Prevent duplicate seat sales per showtime. *Teaches: Encapsulation of seat state, Interface abstraction, Composition (Cinema → Screens → Showtimes), Collection management.*

**OOP Concepts Explicitly Required**  
- ✅ **Encapsulation**: Seat availability tracked internally per showtime  
- ✅ **Abstraction**: `Showtime` interface defines seat operations  
- ✅ **Composition**: `Cinema` → `TheaterScreen` → `Showtime` hierarchy  
- ✅ **Helper Class**: `Ticket` as value object

**Interfaces**  
```java
public interface Showtime {
    LocalDateTime getStartTime();
    Movie getMovie();
    boolean isSeatAvailable(int seatNumber);
    Ticket purchaseTicket(int seatNumber) throws SeatUnavailableException;
}
```

**Classes**  
- `Movie`  
  - Fields: `private String title`, `private int durationMinutes`  
- `TheaterScreen`  
  - Fields: `private int screenNumber`, `private int totalSeats`  
- `Ticket`  
  - Fields: `private int seatNumber`, `private Showtime showtime`, `private LocalDateTime purchaseTime`  
- `CinemaShowtime` implements `Showtime` (concrete implementation)  
  - Fields: `private Movie movie`, `private TheaterScreen screen`, `private LocalDateTime startTime`, `private Set<Integer> soldSeats`  
- `Cinema`  
  - Fields: `private String name`, `private List<TheaterScreen> screens`, `private List<CinemaShowtime> showtimes`

**Constructors**  
- `Movie(String title, int durationMinutes)`  
- `TheaterScreen(int screenNumber, int totalSeats)` – validates `totalSeats > 0`  
- `Cinema(String name)` – initializes empty collections

**Methods to Implement**  
1. `Cinema.scheduleShowtime(Movie movie, TheaterScreen screen, LocalDateTime startTime)`  
2. `CinemaShowtime.purchaseTicket(int seatNumber)` – validates seat exists + not sold  
3. `CinemaShowtime.isSeatAvailable(int seatNumber)` – checks `soldSeats` set  
4. `Cinema.getShowtimesByMovie(String movieTitle)` – returns matching showtimes  
5. `Ticket.getSeatNumber()` – returns assigned seat

**Exceptions**  
- `SeatUnavailableException extends Exception`  
- `InvalidSeatNumberException extends Exception`

**Grading Focus**  
✓ Seat tracking using `Set<Integer>` for O(1) availability checks  
✓ Seat validation: `1 <= seatNumber <= screen.totalSeats`  
✓ Immutable ticket creation (no setters after construction)  
✓ Proper showtime-screen relationship management

---
