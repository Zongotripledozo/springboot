package com.efrei.tp2;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibraryService {
    private final BookRepository bookRepository;
    @Autowired
    public LibraryService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public void rentBook(String isbn, String studentId) {
        Book book = bookRepository.findByIsbn(isbn);
        if (book != null && !book.isRented()) {
            book.setRented(true);
            book.setRentedBy(studentId);
            bookRepository.save(book);
        }
    }

    public void returnBook(String isbn) {
        Book book = bookRepository.findByIsbn(isbn);
        if (book != null && book.isRented()) {
            book.setRented(false);
            book.setRentedBy(null);
            bookRepository.save(book);
        }
    }

    public Map<String, Book> listAvailableBooks() {
        return bookRepository.findAll();
    }
}