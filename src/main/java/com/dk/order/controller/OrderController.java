package com.dk.order.controller;

import com.dk.order.dto.OrderDto;
import com.dk.order.dto.OrderDtoFrontEnd;
import com.dk.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/saveOrder")
    public ResponseEntity<OrderDto> saveOrder(@RequestBody OrderDtoFrontEnd orderDtoFrontEnd){
        OrderDto orderDto= orderService.saveOrderDetails(orderDtoFrontEnd);
        return new ResponseEntity<>(orderDto, HttpStatus.CREATED);

    }
}
