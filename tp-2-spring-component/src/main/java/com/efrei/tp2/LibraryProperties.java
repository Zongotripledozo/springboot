package com.efrei.tp2;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "library")
public class LibraryProperties {
    private int maxBooksByUser;
    private int maxLoanDurationInDays;

    // Getters and Setters
    public int getMaxBooksByUser() {
        return maxBooksByUser;
    }

    public void setMaxBooksByUser(int maxBooksByUser) {
        this.maxBooksByUser = maxBooksByUser;
    }

    public int getMaxLoanDurationInDays() {
        return maxLoanDurationInDays;
    }

    public void setMaxLoanDurationInDays(int maxLoanDurationInDays) {
        this.maxLoanDurationInDays = maxLoanDurationInDays;
    }
}