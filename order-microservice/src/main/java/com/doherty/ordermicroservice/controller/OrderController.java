package com.doherty.ordermicroservice.controller;

import com.doherty.ordermicroservice.entity.LineItem;
import com.doherty.ordermicroservice.entity.OrderDetail;
import com.doherty.ordermicroservice.repository.LineItemRepository;
import com.doherty.ordermicroservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    LineItemRepository lineItemRepository;

    @PostMapping("/orders/{id}/line")
    public void addLineItemForOrder(@PathVariable Long id, @RequestBody LineItem lineItem) {
        OrderDetail order = orderRepository.getOne(id);
        lineItem.setOrderDetail(order);
        lineItemRepository.save(lineItem);
    }

    @GetMapping("/orders/{id}/lines")
    public List<LineItem> getLineItemsForOrder(@PathVariable Long id) {
        return lineItemRepository.findAllLineItemsForOrder(id);
    }

}
