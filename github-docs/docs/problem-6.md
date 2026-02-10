## Problem 6: Coffee Shop Order System

**Description**  
Model coffee shop orders with beverages (`Coffee`, `Tea`) of different sizes. Calculate totals with tax. *Teaches: Inheritance hierarchy, Polymorphic pricing, Enum usage, Composition (Order aggregates Beverages).*

**OOP Concepts Explicitly Required**  
- ✅ **Inheritance**: `Beverage` → `Coffee`, `Tea`  
- ✅ **Polymorphism**: `getPrice()` returns size-adjusted price per subclass  
- ✅ **Encapsulation**: Order total calculated internally; items not directly accessible  
- ✅ **Composition**: `Order` HAS multiple `Beverage` objects  
- ✅ **Enum**: `Size` enum (SMALL, MEDIUM, LARGE)

**Interfaces**  
```java
public interface Beverage {
    String getDescription();
    double getPrice();
}
```

**Classes**  
- `Size` enum: `SMALL`, `MEDIUM`, `LARGE`  
- `Coffee` implements `Beverage`  
  - Fields: `private String type`, `private Size size`  
  - Pricing: SMALL=$2.50, MEDIUM=$3.50, LARGE=$4.50  
- `Tea` implements `Beverage`  
  - Fields: `private String variety`, `private Size size`  
  - Pricing: SMALL=$2.00, MEDIUM=$3.00, LARGE=$4.00  
- `Order`  
  - Fields: `private String customerName`, `private LocalDateTime orderTime`, `private List<Beverage> items`  
- `CoffeeShop`  
  - Fields: `private List<Order> orders`, `private static final double TAX_RATE = 0.085`

**Constructors**  
- `Coffee(String type, Size size)`  
- `Tea(String variety, Size size)`  
- `Order(String customerName)` – sets `orderTime = LocalDateTime.now()`

**Methods to Implement**  
1. `Order.addBeverage(Beverage beverage)`  
2. `Order.calculateSubtotal()` – sums `beverage.getPrice()` for all items  
3. `Order.calculateTotal()` – returns `subtotal * (1 + TAX_RATE)` rounded to 2 decimals  
4. `Coffee.getDescription()` – returns `"Latte (MEDIUM)"` format  
5. `CoffeeShop.placeOrder(Order order)` – validates non-empty, assigns ID, stores order

**Exceptions**  
- `EmptyOrderException extends Exception`

**Grading Focus**  
✓ Enum usage for size (no String literals for sizes)  
✓ Polymorphic pricing: `order.calculateSubtotal()` calls `beverage.getPrice()` without knowing type  
✓ Tax rounding: `Math.round(total * 100.0) / 100.0`  
✓ Validation BEFORE state change (check empty order before adding to shop)

---
