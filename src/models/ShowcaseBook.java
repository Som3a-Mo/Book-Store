package models;

public class ShowcaseBook extends Book {

    public ShowcaseBook(String ISBN, String title, int yearPublished) {
        super(ISBN, title, yearPublished, 0);
    }

    @Override
    public void deliver(int quantity, String email, String address) {
        throw new UnsupportedOperationException("Not supported operation for ShowcaseBook.");
    }
}
