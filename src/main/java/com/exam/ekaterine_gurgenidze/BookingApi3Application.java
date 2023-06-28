package com.exam.ekaterine_gurgenidze;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BookingApi3Application {

    public static void main(String[] args) {
        SpringApplication.run(BookingApi3Application.class, args);
    }

}
