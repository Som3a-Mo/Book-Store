package services;

import models.Book;
import models.EBook;

public class MailService {
    public static void send(String email, Book book, int quantity) {
        EBook ebook = (EBook) book;
        System.out.println("Sending " + quantity + " license/licenses of '" +
                ebook.getTitle() + "' (" + ebook.getFileType() + ") to " + email);
    }
}
