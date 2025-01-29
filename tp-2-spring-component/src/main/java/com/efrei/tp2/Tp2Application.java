package com.efrei.tp2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class Tp2Application {

    public static void main(String[] args) {
        SpringApplication.run(Tp2Application.class, args);
    }
}
