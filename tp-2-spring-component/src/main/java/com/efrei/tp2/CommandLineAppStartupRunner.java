package com.efrei.tp2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {
    private final LibraryService libraryService;

    public CommandLineAppStartupRunner(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @Override
    public void run(String... args) throws Exception {
        Book book1 = new Book("123", "Spring in Action", "Craig Walls");
        Book book2 = new Book("456", "Spring Boot in Practice", "Somnath Musib");

        libraryService.addBook(book1);
        libraryService.addBook(book2);

        libraryService.rentBook("123", "student1");

        System.out.println("Available books:");
        libraryService.listAvailableBooks().values().forEach(book -> {
            System.out.println(book.getTitle() + " by " + book.getAuthor() + " - Rented: " + book.isRented());
        });

        libraryService.returnBook("123");

        System.out.println("Available books after return:");
        libraryService.listAvailableBooks().values().forEach(book -> {
            System.out.println(book.getTitle() + " by " + book.getAuthor() + " - Rented: " + book.isRented());
        });
    }
}
