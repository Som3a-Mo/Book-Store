# 📚 Quantum Bookstore Inventory System

A simple Java-based bookstore system that supports inventory management, purchasing (both physical and digital books), and handling showcase books. The system demonstrates core OOP principles like inheritance, polymorphism, and encapsulation.

---

## 🛠️ Features

- Add new books to inventory:
  - `PaperBook`: Physical books with stock tracking.
  - `EBook`: Digital books with email delivery.
  - `ShowcaseBook`: Display-only books (not for sale).
- Remove outdated books based on age.
- Simulate purchasing of books.
- Handle delivery via email or shipping service.
- Demonstrates clean separation of concerns with services.


## 🧱 Project Structure
<details>
<summary>Click to expand!</summary>

```bash
├── Main.java # Main test runner
├── models/
│ ├── Book.java # Abstract base class
│ ├── EBook.java # EBook implementation
│ ├── FileType.java # Enum for file types
│ ├── Inventory.java # Bookstore inventory logic
│ ├── PaperBook.java # Paper book implementation
│ ├── ShowcaseBook.java # Display-only books
├── services/
│ ├── MailService.java # Simulates sending e-books via email
│ └── ShippingService.java # Simulates shipping for paper books
```
</details>

## 📦 Sample Demo (from Main.java):


```csh
int currentYear = 2025;

store.addBook(new PaperBook("ISBN001", "Java Fundamentals", currentYear - 5, 29.99, 50));
store.addBook(new EBook("ISBN002", "Advanced Java", currentYear - 2, 19.99, FileType.PDF));
store.addBook(new ShowcaseBook("ISBN003", "Java History", currentYear - 8));
store.addBook(new ShowcaseBook("ISBN004", "Java History", currentYear - 20));

System.out.println("** Testing Book Removal **");
List<Book> outdated = store.removeOutdatedBooks(10);
System.out.println("Removed " + outdated.size() + " outdated books");

System.out.println("\n** Testing Buy Book Operation  **");
testBuyOperation(store, "ISBN001", 2, "esmail@gmail.com", "Cairo");
testBuyOperation(store, "ISBN002", 1, "Som3a-mo@gmail.com", "Giza");

System.out.println("\n** Testing Edge Cases **");
testBuyOperation(store, "ISBN003", 1, "", "");
testBuyOperation(store, "ISBN001", 100, "", "456 Oak Ave");
testBuyOperation(store, "BlaBlaBla-ISBN", 1, "", "");
```
```bash
** Testing Book Removal **
Removed 1 outdated books

** Testing Buy Book Operation **
Purchased 2 of ISBN001: $59.98
Purchased 1 of ISBN002: $19.99

** Testing Edge Cases **
Purchase failed: This book is not for sale
Purchase failed: Insufficient stock
Purchase failed: Book not found
```

## 💡 Technologies Used

- Java 17+
- Object-Oriented Programming (OOP)
- Basic Java Collections (`HashMap`, `ArrayList`)
- Exception handling
- Java Time API

## 🚀 How to Run

1. Clone the repository or copy the source files.
2. Compile and run `Main.java`.
3. Observe the outputs in console for different operations.

