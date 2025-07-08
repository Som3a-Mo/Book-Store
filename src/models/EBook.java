package models;

import services.MailService;

public class EBook extends Book {
    private FileType fileType;

    public EBook(String ISBN, String title, int yearPublished, double price, FileType fileType) {
        super(ISBN, title, yearPublished, price);
        this.fileType = fileType;
    }

    public FileType getFileType() {
        return fileType;
    }

    @Override
    public void deliver(int quantity, String email, String address) {
        MailService.send(email, this, quantity);
    }
}
