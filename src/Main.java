import models.EBook;
import models.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Inventory store = new Inventory();
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

    }

    private static void testBuyOperation(Inventory store, String isbn, int quantity,
                                     String email, String address) {
        try {
            double cost = store.buyBook(isbn, quantity, email, address);
            System.out.printf("Purchased %d of %s: $%.2f\n", quantity, isbn, cost);
        } catch (Exception e) {
            System.out.println("Purchase failed: " + e.getMessage());
        }
    }
}