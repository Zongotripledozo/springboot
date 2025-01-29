package com.efrei.tp2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {
    private final LibraryService libraryService;

    @Autowired
    public CommandLineAppStartupRunner(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @Override
    public void run(String... args) throws Exception {
        Book book1 = new Book("123", "Spring in Action", "Craig Walls");
        Book book2 = new Book("456", "Spring Boot in Practice", "Somnath Musib");
        Book book3 = new Book("789", "Effective Java", "Joshua Bloch");

        libraryService.addBook(book1);
        libraryService.addBook(book2);
        libraryService.addBook(book3);

        libraryService.rentBook("123", "student1");
        libraryService.rentBook("456", "student1");

        System.out.println("Available books:");
        libraryService.listAvailableBooks().values().forEach(book -> {
            System.out.println(book.getTitle() + " by " + book.getAuthor() + " - Rented: " + book.isRented());
        });

        System.out.println("Rented books:");
        libraryService.listRentedBooks().values().forEach(book -> {
            System.out.println(book.getTitle() + " by " + book.getAuthor() + " - Rented by: " + book.getRentedBy());
        });

        libraryService.returnBook("123");

        System.out.println("Available books after return:");
        libraryService.listAvailableBooks().values().forEach(book -> {
            System.out.println(book.getTitle() + " by " + book.getAuthor() + " - Rented: " + book.isRented());
        });
    }
}
