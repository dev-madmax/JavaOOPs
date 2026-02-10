# OOP Practice Problems

## Table of Contents

- [Problem 1](problem-01.md)

- [Problem 2](problem-02.md)

- [Problem 3](problem-03.md)

- [Problem 4](problem-04.md)

- [Problem 5](problem-05.md)

- [Problem 6](problem-06.md)

- [Problem 7](problem-07.md)

- [Problem 8](problem-08.md)

- [Problem 9](problem-09.md)

- [Problem 10](problem-10.md)

- [Problem 11](problem-11.md)

- [Problem 12](problem-12.md)

- [Problem 13](problem-13.md)

- [Problem 14](problem-14.md)

- [Problem 15](problem-15.md)

---
---

## OOP Concepts Coverage Matrix

| Problem | Inheritance | Polymorphism | Encapsulation | Abstraction (Interfaces) | Composition/Aggregation |
|---------|-------------|--------------|---------------|--------------------------|-------------------------|
| 1 | ✓ (Book hierarchy) | ✓ (borrow/return behavior) | ✓ (private status fields) | ✓ (`Borrowable`) | ✓ (Library → Books/Members) |
| 2 | ✓ (`Vehicle` → `Car`/`Motorcycle`) | ✓ (`getSpaceRequired()`) | ✓ (private occupancy) | ✓ (`Parkable`) | ✓ (ParkingLot → Vehicles) |
| 3 | ✓ (`BankAccount` → `Savings`/`Checking`) | ✓ (withdraw behavior) | ✓ (private balance) | ✓ (`Account`) | ✓ (Bank → Accounts) |
| 4 | — | — | ✓ (private attendance maps) | ✓ (`Attendee`) | ✓✓ (Course → Sessions → Students) |
| 5 | ✓ (`Room` → `Standard`/`Deluxe`) | ✓ (identical booking behavior) | ✓ (private bookings) | ✓ (`Bookable`) | ✓ (Hotel → Rooms) |
| 6 | ✓ (`Beverage` → `Coffee`/`Tea`) | ✓ (size-based pricing) | ✓ (private order items) | ✓ (`Beverage`) | ✓✓ (Order → Beverages) |
| 7 | ✓ (`Animal` → `Carnivore`/`Herbivore`) | ✓✓ (different feeding intervals) | ✓ (private lastFed) | ✓ (`Feedable`) | ✓ (Zoo → Animals) |
| 8 | — | — | ✓ (private song list) | ✓ (`Playable`) | ✓✓ (Playlist → Songs) |
| 9 | — | — | ✓ (private visit history) | ✓✓ (`MemberTier` strategy) | ✓✓ (Member → Tier) |
| 10 | — | — | ✓ (private reservations) | ✓ (`Reservable`) | ✓✓ (Table → Reservations) |
| 11 | — | — | ✓ (private completion state) | ✓ (`TaskItem`) | ✓ (TaskList → Tasks) |
| 12 | — | — | ✓ (private seat tracking) | ✓ (`BookableFlight`) | ✓ (Flight → Passengers) |
| 13 | ✓ (`Pet` → `Dog`/`Cat`) | ✓✓ (species-specific rules) | ✓ (private adoption status) | ✓ (`Adoptable`) | ✓ (AdoptionCenter → Pets) |
| 14 | — | — | ✓ (private seat map) | ✓ (`Showtime`) | ✓✓ (Cinema → Screens → Showtimes) |
| 15 | ✓ (`Crop` implementations) | ✓✓ (growth period polymorphism) | ✓ (private planting date) | ✓ (`Crop`) | ✓ (Farm → Fields) |

---
