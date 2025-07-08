package services;

import models.Book;

public class ShippingService {
    public static void ship(String address, Book book, int quantity) {
        System.out.println("Shipping " + quantity + " copy/copies of '" +
                book.getTitle() + "' to " + address);
    }
}
