package models;

import services.ShippingService;

public class PaperBook extends Book {
    private int stock;

    public PaperBook(String ISBN, String title, int yearPublished, double price, int stock) {
        super(ISBN, title, yearPublished, price);
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    @Override
    public void deliver(int quantity, String email, String address) {
        if (quantity > stock) {
            throw new IllegalArgumentException("Insufficient stock");
        }
        this.stock -= quantity;
        ShippingService.ship(address, this, quantity);
    }
}
