package models;
import java.time.Year;
import java.util.*;

public class Inventory {
    private HashMap<String, Book> books = new HashMap<>();

    public void addBook(Book book) {
        books.put(book.getISBN(), book);
    }

    public List<Book> removeOutdatedBooks(int maxAgeYears) {

        List<Book> outdatedBooks = new ArrayList<>();
        int currentYear = Year.now().getValue();
//        for (String ISBN : books.keySet()) {
//            Book book = books.get(ISBN);
//            if (currentYear - book.getYearPublished() > maxAgeYears) {
//                outdatedBooks.add(book);
//                books.remove(ISBN);
//            }
//        }
        Iterator<Map.Entry<String, Book>> iterator = books.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Book> entry = iterator.next();
            Book book = entry.getValue();
            if (currentYear - book.getYearPublished() > maxAgeYears) {
                outdatedBooks.add(book);
                iterator.remove();
            }
        }

        return outdatedBooks;
    }

    public double buyBook(String ISBN, int quantity, String email, String address) {
        Book book = books.get(ISBN);

        if (book == null) {
            throw new IllegalArgumentException("Book not found");
        }
        if (book instanceof ShowcaseBook){
            throw new UnsupportedOperationException("This book is not for sale");
        }
        if (book instanceof PaperBook){
            PaperBook paperBook = (PaperBook) book;
            if (paperBook.getStock() < quantity) {
                throw new IllegalArgumentException("Insufficient stock");
            }
        }

        double totalCost = book.getPrice() * quantity;
        book.deliver(quantity, email, address);
        return totalCost;
    }

}
