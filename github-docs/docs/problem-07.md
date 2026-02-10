## Problem 7: Zoo Animal Feeding System

**Description**  
Track animal feedings with species-specific intervals: `Carnivore` (12 hrs) vs `Herbivore` (8 hrs). *Teaches: Inheritance with behavioral differences, Polymorphism, Encapsulation of feeding timestamps, Interface abstraction.*

**OOP Concepts Explicitly Required**  
- ✅ **Inheritance**: `Animal` (abstract) → `Carnivore`, `Herbivore`  
- ✅ **Polymorphism**: `needsFeeding()` logic differs per subclass (runtime binding)  
- ✅ **Abstraction**: `Feedable` interface defines feeding contract  
- ✅ **Encapsulation**: `lastFed` timestamp private; accessed via methods only

**Interfaces**  
```java
public interface Feedable {
    String getDietType();
    void feed(LocalDateTime time);
    boolean needsFeeding(LocalDateTime currentTime);
}
```

**Classes**  
- `Animal` (abstract) implements `Feedable`  
  - Fields: `protected String name`, `protected String species`, `protected LocalDateTime lastFed`  
  - Constructor: `Animal(String name, String species)`  
- `Carnivore extends Animal`  
  - `needsFeeding()`: returns `true` if >12 hours since `lastFed`  
  - `getDietType()`: returns `"Meat"`  
- `Herbivore extends Animal`  
  - `needsFeeding()`: returns `true` if >8 hours since `lastFed`  
  - `getDietType()`: returns `"Plants"`  
- `Zoo`  
  - Fields: `private String name`, `private List<Animal> animals`

**Constructors**  
- `Carnivore(String name, String species)` – calls `super(name, species)`  
- `Herbivore(String name, String species)` – calls `super(name, species)`  
- `Zoo(String name)` – initializes empty animal list

**Methods to Implement**  
1. `Zoo.addAnimal(Animal animal)`  
2. `Animal.feed(LocalDateTime time)` – sets `lastFed = time`  
3. `Animal.needsFeeding(LocalDateTime currentTime)` – overridden per subclass  
4. `Zoo.getAnimalsNeedingFood(LocalDateTime now)` – returns animals where `needsFeeding(now) == true`  
5. `Zoo.feedAll(LocalDateTime now)` – feeds all animals that need food

**Exceptions**  
- `AlreadyFeedException extends Exception` – thrown if feeding before required interval

**Grading Focus**  
✓ Method overriding with different time intervals per subclass  
✓ Proper null handling for `lastFed` (never fed → needs feeding)  
✓ Time calculation using `ChronoUnit.HOURS.between(lastFed, currentTime)`  
✓ Polymorphic collection: `List<Animal>` holds both `Carnivore` and `Herbivore`

---
