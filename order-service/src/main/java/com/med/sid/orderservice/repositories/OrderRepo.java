package com.med.sid.orderservice.repositories;

import com.med.sid.orderservice.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface OrderRepo extends JpaRepository<Order, Long> {
    @RestResource(path = "/byCustomerId")
    List<Order> findByCustomerId(@Param("customerId") Long customerId);
}
