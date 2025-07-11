# 📚 Quantum Bookstore Inventory System

A simple Java-based bookstore system that supports inventory management, purchasing (both physical and digital books), and handling showcase books. The system demonstrates core OOP principles like inheritance, polymorphism, and encapsulation.


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

## Diagrams
### Class Diagram
```mermaid
classDiagram

class Book {
    <<Abstract>>
    -String ISBN
    -String title
    -int yearPublished
    -double price
    +getISBN()
    +getTitle()
    +getYearPublished()
    +getPrice()
    +deliver(quantity, email, address)*
}

class EBook {
    -FileType fileType
    +getFileType()
    +deliver(quantity, email, address)
}

class PaperBook {
    -int stock
    +getStock()
    +deliver(quantity, email, address)
}

class ShowcaseBook {
    +deliver(quantity, email, address)
}

class Inventory {
    -HashMap~String, Book~ books
    +addBook(book)
    +removeOutdatedBooks(maxAgeYears)
    +buyBook(ISBN, quantity, email, address)
}

class FileType {
    <<Enumeration>>
    DOC
    PDF
    TXT
    DOCX
    RTF
    ODT
}

Book <|-- EBook
Book <|-- PaperBook
Book <|-- ShowcaseBook
Inventory --> Book
EBook --> FileType

class MailService {
    +send(email, book, quantity)$
}

class ShippingService {
    +ship(address, book, quantity)$
}

EBook ..> MailService : uses
PaperBook ..> ShippingService : uses

```
### Sequence Diagram
```mermaid
sequenceDiagram
    participant Customer
    participant Inventory
    participant Book
    participant EBook
    participant MailService
    participant PaperBook
    participant ShippingService

    Customer->>Inventory: buyBook(ISBN, quantity, email, address)
    Inventory->>Book: getPrice()
    Inventory->>Book: deliver(quantity, email, address)

    alt Book is EBook
        Book->>EBook: deliver()
        EBook->>MailService: send(email, book, quantity)
    else Book is PaperBook
        Book->>PaperBook: deliver()
        PaperBook->>ShippingService: ship(address, book, quantity)
    else Book is ShowcaseBook
        Book->>ShowcaseBook: deliver()
        ShowcaseBook--xInventory: throw UnsupportedOperationException
    end

    Inventory-->>Customer: return totalCost
```
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

** Testing Buy Book Operation  **
Shipping 2 copy/copies of 'Java Fundamentals' to Cairo
Purchased 2 of ISBN001: $59.98
Sending 'Advanced Java' (PDF) to Som3a-mo@gmail.com
Purchased 1 of ISBN002: $19.99

** Testing Edge Cases **
Purchase failed: This book is not for sale
Purchase failed: Insufficient stock
Purchase failed: Book not found
```
### Screenshots 
![image](https://github.com/user-attachments/assets/f3b9320b-851a-4b17-a6d3-d750a06d2fce)
![image](https://github.com/user-attachments/assets/619778c1-54bd-4d34-9a45-5c74bd431552)


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

