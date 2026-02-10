## Problem 1: Library Book Management System

**Description**  
Model a library where books can be borrowed/returned by members. Members cannot borrow >3 books. Books track availability state. *Teaches: Inheritance (optional Book hierarchy), Interface abstraction, Encapsulation of state, Composition (Library aggregates Books/Members).*

**OOP Concepts Explicitly Required**  
- ✅ **Encapsulation**: All fields private; state changed only via methods  
- ✅ **Abstraction**: `Borrowable` interface defines borrowing contract  
- ✅ **Composition**: `Library` has collections of `Book` and `Member`  
- ✅ **Polymorphism**: Future extension to `EBook`/`PhysicalBook` (optional bonus)

**Interfaces**  
```java
public interface Borrowable {
    boolean borrow(Member member);
    void returnItem();
    boolean isAvailable();
}
```

**Classes**  
- `Book` implements `Borrowable`  
  - Fields: `private String isbn`, `private String title`, `private String author`, `private boolean available`, `private Member currentBorrower`  
- `Member`  
  - Fields: `private int id`, `private String name`, `private List<Book> borrowedBooks`  
- `Library`  
  - Fields: `private List<Book> books`, `private List<Member> members`

**Constructors**  
- `Book(String isbn, String title, String author)` – sets `available = true`  
- `Member(int id, String name)` – initializes empty `borrowedBooks` list  
- `Library()` – initializes empty collections

**Methods to Implement**  
1. `Library.registerMember(Member member)`  
2. `Library.addBook(Book book)`  
3. `Library.borrowBook(String isbn, int memberId)` – throws exceptions if rules violated  
4. `Book.isAvailable()` – returns `available` status  
5. `Member.getBorrowedCount()` – returns `borrowedBooks.size()`

**Exceptions**  
- `BookUnavailableException extends Exception`  
- `MemberLimitExceededException extends Exception`

**Grading Focus**  
✓ No public fields  
✓ Bidirectional relationship: Book knows borrower ↔ Member knows borrowed books  
✓ Validation before state change (check limits BEFORE modifying collections)  
✓ Proper exception messages with contextual data (`"Book ISBN-123 is unavailable"`)

---
