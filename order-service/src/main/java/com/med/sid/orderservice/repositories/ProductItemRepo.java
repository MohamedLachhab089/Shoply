package com.med.sid.orderservice.repositories;

import com.med.sid.orderservice.entities.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProductItemRepo extends JpaRepository<ProductItem, Long> {
}
