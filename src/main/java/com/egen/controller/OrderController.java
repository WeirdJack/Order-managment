package com.egen.controller;

import com.egen.model.Order;
import com.egen.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    /**
     * implement the following endpoints
     */

    @Autowired
    private OrderService orderService;

    @GetMapping("/")
    public ResponseEntity<List<Order>> getAllOrders(){
        return ResponseEntity.ok(orderService.findAllOrders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable String id){
        return ResponseEntity.ok(orderService.findOrderById(id));
    }

    @GetMapping("/{startTime}/{endTime}")
    public ResponseEntity<List<Order>> getAllOrdersWithInInterval(ZonedDateTime startTime, ZonedDateTime endTime){
        return ResponseEntity.ok(orderService.findAllOrdersWithInInterval(startTime, endTime));
    }

    @GetMapping("/topOrdersInZip/{zip}")
    public ResponseEntity<List<Order>> top10OrdersWithHighestDollarAmountInZip(String zip){
        return ResponseEntity.ok(orderService.top10OrdersWithHighestDollarAmountInZip(zip));
    }

    @PostMapping("/create")
    public ResponseEntity<Order> placeOrder(Order order){
        return new ResponseEntity(orderService.createOrder(order), HttpStatus.CREATED);
    }

    @PutMapping("/cancel")
    public ResponseEntity<Order> cancelOrder(Order order){
        return ResponseEntity.ok(orderService.cancelOrder(order));
    }

    @PutMapping("/update")
    public ResponseEntity<Order> updateOrder(Order order){
        return ResponseEntity.ok(orderService.updateOrder(order));
    }
}
