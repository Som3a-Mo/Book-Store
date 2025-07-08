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

        double totalCost = book.getPrice() * quantity;
        try {
            book.deliver(quantity, email, address);
        }catch (Exception e){
            throw e;
        }
        return totalCost;
    }

}
