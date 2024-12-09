package com.med.sid.inventoryservice;

import com.med.sid.inventoryservice.entites.Product;
import com.med.sid.inventoryservice.repositories.ProductRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableDiscoveryClient // make the service visible to other with name and metadata.
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ProductRepo productRepository) {
        return args -> {
            Random random = new Random();
            for (int i = 1; i < 10; i++) {
                productRepository.saveAll(List.of(
                        Product.builder()
                                .name("Computer " + i)
                                .price(1200 + Math.random() * 10000)
                                .quantity(1 + random.nextInt(200)).build()
                ));
            }
        };
    }

}
