package com.efrei.tp2;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class BookRepository {
    private final Map<String, Book> books = new HashMap<>();

    public void save(Book book) {
        books.put(book.getIsbn(), book);
    }

    public Book findByIsbn(String isbn) {
        return books.get(isbn);
    }

    public Map<String, Book> findAll() {
        return books;
    }

    public void delete(String isbn) {
        books.remove(isbn);
    }
}
