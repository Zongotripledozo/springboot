package com.efrei.tp2;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class LibraryService {
    private final BookRepository bookRepository;

    public LibraryService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public void rentBook(String isbn, String studentId) {
        Book book = bookRepository.findByIsbn(isbn);
        if (book != null && !book.isRented()) {
            book.setRentedBy(studentId);
            bookRepository.save(book);
        }
    }

    public void returnBook(String isbn) {
        Book book = bookRepository.findByIsbn(isbn);
        if (book != null && book.isRented()) {
            book.setRentedBy(null);
            bookRepository.save(book);
        }
    }

    public List<Book> listAvailableBooks() {
        var listbook = bookRepository.findAll().values();
        return listbook.stream()
                .filter(book -> !book.isRented())
                .toList();

        // List<Book> res = new ArrayList<>();
        // for (Book book : listbook) {
        //     if (!book.isRented()) {
        //         res.add(book);
        //     }
        // }
        // return res;
    }
}