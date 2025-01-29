package com.efrei.tp1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Tp1Application {

	public static void main(String[] args) {
		var springApp = SpringApplication.run(Tp1Application.class, args);
		var myServiceConsumer = springApp.getBean(MyServiceConsumer.class);

		myServiceConsumer.useService();
	}

}

