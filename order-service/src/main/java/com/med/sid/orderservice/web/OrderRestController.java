package com.med.sid.orderservice.web;

import com.med.sid.orderservice.entities.Order;
import com.med.sid.orderservice.model.Customer;
import com.med.sid.orderservice.model.Product;
import com.med.sid.orderservice.repositories.OrderRepo;
import com.med.sid.orderservice.repositories.ProductItemRepo;
import com.med.sid.orderservice.services.CustomerRestClientService;
import com.med.sid.orderservice.services.InventoryRestClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderRestController {
    private final OrderRepo orderRepository;
    private final ProductItemRepo productItemRepository;
    private final CustomerRestClientService customerRestClientService;
    private final InventoryRestClientService inventoryRestClientService;

    @GetMapping("/fullOrder/{id}")
    public Order getOrder(@PathVariable Long id) {
        Order order = orderRepository.findById(id).get();
        Customer customer = customerRestClientService.customerById(order.getCustomerId());
        order.setCustomer(customer);
        order.getProductItems().forEach(pi -> {
            Product product = inventoryRestClientService.productById(pi.getProductId());
            pi.setProduct(product);
        });
        return order;
    }

}
