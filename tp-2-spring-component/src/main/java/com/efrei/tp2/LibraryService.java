package com.efrei.tp2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;

@Service
public class LibraryService {
    private final BookRepository bookRepository;
    private final LibraryProperties libraryProperties;

    @Autowired
    public LibraryService(BookRepository bookRepository, LibraryProperties libraryProperties) {
        this.bookRepository = bookRepository;
        this.libraryProperties = libraryProperties;
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public void rentBook(String isbn, String studentId) {
        Book book = bookRepository.findByIsbn(isbn);
        if (book != null && !book.isRented()) {
            long rentedBooksCount = bookRepository.findAll().values().stream()
                    .filter(b -> studentId.equals(b.getRentedBy()))
                    .count();
            if (rentedBooksCount < libraryProperties.getMaxBooksByUser()) {
                book.setRented(true);
                book.setRentedBy(studentId);
                bookRepository.save(book);
            } else {
                System.out.println("Student has reached the maximum number of rented books.");
            }
        } else {
            System.out.println("Book is already rented or does not exist.");
        }
    }

    public void returnBook(String isbn) {
        Book book = bookRepository.findByIsbn(isbn);
        if (book != null && book.isRented()) {
            book.setRented(false);
            book.setRentedBy(null);
            bookRepository.save(book);
        } else {
            System.out.println("Book is not rented or does not exist.");
        }
    }

    public Map<String, Book> listAvailableBooks() {
        return bookRepository.findAll().values().stream()
                .filter(book -> !book.isRented())
                .collect(Collectors.toMap(Book::getIsbn, book -> book));
    }

    public Map<String, Book> listRentedBooks() {
        return bookRepository.findAll().values().stream()
                .filter(Book::isRented)
                .collect(Collectors.toMap(Book::getIsbn, book -> book));
    }
}