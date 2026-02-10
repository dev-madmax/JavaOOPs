## Problem 13: Pet Adoption Center

**Description**  
Model animal shelter with species-specific adoption rules: LARGE `Dog` requires yard, `Cat` has no restrictions. *Teaches: Inheritance with behavioral differences, Polymorphism, Encapsulation of adoption state, Interface abstraction.*

**OOP Concepts Explicitly Required**  
- ✅ **Inheritance**: `Pet` (abstract) → `Dog`, `Cat`  
- ✅ **Polymorphism**: `isSuitableForApplicant()` logic differs per subclass  
- ✅ **Abstraction**: `Adoptable` interface defines adoption contract  
- ✅ **Encapsulation**: Adoption status private; changed only via `adopt()`

**Interfaces**  
```java
public interface Adoptable {
    String getSpecies();
    String getSize(); // "SMALL", "MEDIUM", "LARGE"
    boolean isAdoptable();
    boolean isSuitableForApplicant(boolean hasYard);
}
```

**Classes**  
- `Pet` (abstract) implements `Adoptable`  
  - Fields: `protected String name`, `protected int age`, `protected boolean adopted`  
  - Constructor: `Pet(String name, int age)`  
- `Dog extends Pet`  
  - Additional field: `private String size` ("SMALL", "MEDIUM", "LARGE")  
  - `isSuitableForApplicant(boolean hasYard)`: returns `size.equals("LARGE") ? hasYard : true`  
- `Cat extends Pet`  
  - `isSuitableForApplicant(boolean hasYard)`: always returns `true`  
- `AdoptionCenter`  
  - Fields: `private String name`, `private List<Pet> pets`

**Constructors**  
- `Dog(String name, int age, String size)` – validates size is one of three values  
- `Cat(String name, int age)`  
- `AdoptionCenter(String name)` – initializes empty pet list

**Methods to Implement**  
1. `AdoptionCenter.addPet(Pet pet)`  
2. `AdoptionCenter.submitApplication(String applicantName, boolean hasYard, Pet pet)` – validates suitability before adoption  
3. `Pet.adopt()` – sets `adopted = true`  
4. `AdoptionCenter.getAvailablePets()` – returns pets where `isAdoptable() == true`  
5. `Dog.getSize()` – returns size string

**Exceptions**  
- `UnsuitableAdoptionException extends Exception`

**Grading Focus**  
✓ Method overriding with species-specific suitability logic  
✓ Adoption state management (`adopted` flag)  
✓ Validation BEFORE state change (check suitability before calling `adopt()`)  
✓ Polymorphic collection: `List<Pet>` holds both `Dog` and `Cat`

---
