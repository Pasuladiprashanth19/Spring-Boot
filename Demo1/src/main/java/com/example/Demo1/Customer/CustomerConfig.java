package com.example.Demo1.Customer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.awt.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.APRIL;

@Configuration
public class CustomerConfig {

@Bean
    CommandLineRunner commandLineRunner(CustomerRepository repository)
{
        return args -> {
            Customer Prashanth =new Customer(1L,
                    "prashanth",
                    "prashanth@gmail.com",
                    LocalDate.of(2000, APRIL,12)
            );

            Customer Sai=new Customer(2L,
                    "Sai",
                    "Sai@gmail.com",
                    LocalDate.of(2004, APRIL,12)
            );


            repository.saveAll(
                    List.of(Prashanth,Sai)
            );
        };
    }
}
