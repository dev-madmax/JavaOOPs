## Problem 15: Farm Crop Management System

**Description**  
Model farm fields with crops having different growth periods: `TomatoCrop` (60 days) vs `CornCrop` (90 days). Prevent premature harvesting. *Teaches: Inheritance with behavioral differences, Polymorphism, Encapsulation of planting date, Interface abstraction.*

**OOP Concepts Explicitly Required**  
- ✅ **Inheritance**: Multiple classes implement `Crop` interface (no abstract parent needed)  
- ✅ **Polymorphism**: `getGrowthDays()` returns different values per crop type  
- ✅ **Abstraction**: `Crop` interface defines growth contract  
- ✅ **Encapsulation**: Planting date stored privately in `Field`

**Interfaces**  
```java
public interface Crop {
    String getName();
    int getGrowthDays();
    boolean isReadyToHarvest(LocalDate plantDate, LocalDate currentDate);
}
```

**Classes**  
- `TomatoCrop` implements `Crop`  
  - `getName()` returns `"Tomato"`  
  - `getGrowthDays()` returns `60`  
- `CornCrop` implements `Crop`  
  - `getName()` returns `"Corn"`  
  - `getGrowthDays()` returns `90`  
- `Field`  
  - Fields: `private int fieldId`, `private Crop currentCrop`, `private LocalDate plantingDate`  
- `Farm`  
  - Fields: `private String name`, `private List<Field> fields`

**Constructors**  
- `TomatoCrop()`  
- `CornCrop()`  
- `Field(int fieldId)` – initializes with `currentCrop = null`, `plantingDate = null`  
- `Farm(String name)` – initializes empty field list

**Methods to Implement**  
1. `Farm.addField(Field field)`  
2. `Field.plantCrop(Crop crop, LocalDate plantDate)` – validates field empty before planting  
3. `Field.harvest(LocalDate currentDate)` – throws if not ready; returns yield string; clears field  
4. `Field.getDaysUntilHarvest(LocalDate currentDate)` – calculates remaining days (negative if ready)  
5. `Farm.getFieldsReadyToHarvest(LocalDate date)` – returns fields where crop is mature

**Exceptions**  
- `CropNotReadyException extends Exception`  
- `FieldOccupiedException extends Exception`

**Grading Focus**  
✓ Interface implementation without inheritance hierarchy (demonstrates interface power)  
✓ Date calculation using `ChronoUnit.DAYS.between(plantingDate, currentDate)`  
✓ Field state management: crop + planting date must be set/cleared together  
✓ Validation BEFORE state change (check readiness before harvesting)

---

## Appendix: Grading Rubric (All Problems)

| Criteria | Points | Requirements |
|----------|--------|--------------|
| **Class & Interface Design** | 20 | Correct number of classes/interfaces; proper relationships; all required elements present |
| **Inheritance/Polymorphism** | 20 | Proper use of abstract classes/interfaces; method overriding where required; runtime polymorphism demonstrated |
| **Encapsulation** | 20 | All fields private; no public fields; state accessed ONLY via methods; no collection exposure |
| **Constructors** | 15 | All required constructors implemented; validation where specified; proper chaining (super/this) |
| **Method Implementation** | 15 | All methods implemented with correct signatures; business logic accurate; proper return types |
| **Exception Handling** | 10 | Custom exceptions defined; thrown at correct points; meaningful messages with context |

**Total Points per Problem:** 100

---

## Instructions for Students

1. Create a new Java project for each problem  
2. Implement ALL required classes, interfaces, and exceptions  
3. Do NOT use: Streams, Lambdas, Reflection, Concurrency, or external libraries  
4. Use only core Java (java.lang, java.util, java.time)  
5. Write clean, readable code with meaningful names  
6. Validate inputs BEFORE changing state  
7. Return unmodifiable collections when exposing internal lists/maps  

---