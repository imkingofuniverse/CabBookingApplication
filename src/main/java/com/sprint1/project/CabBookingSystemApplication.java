package com.sprint1.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CabBookingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(CabBookingSystemApplication.class, args);
		System.out.println("Cab booking started...");
	}

}
