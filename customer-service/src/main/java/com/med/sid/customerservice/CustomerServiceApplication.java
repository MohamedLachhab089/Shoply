package com.med.sid.customerservice;

import com.med.sid.customerservice.entites.Customer;
import com.med.sid.customerservice.repositories.CustomerRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerRepo customerRepository) {
        return args -> {
            customerRepository.saveAll(List.of(
                    Customer.builder().name("Mohamed").email("med@gmail.com").build(),
                    Customer.builder().name("Hamza").email("hamza@gmail.com").build(),
                    Customer.builder().name("Ayoub").email("ayoub@gmail.com").build()
            ));
            customerRepository.findAll().forEach(System.out::println);
        };
    }

}
