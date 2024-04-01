package com.dk.order.service;

import com.dk.order.dto.OrderDto;
import com.dk.order.dto.OrderDtoFrontEnd;
import com.dk.order.dto.UserDto;
import com.dk.order.entity.Order;
import com.dk.order.mapper.OrderMapper;
import com.dk.order.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    OrderRepo orderRepo;

    @Autowired
    SequenceGenerator sequenceGenerator;
    @Autowired
    RestTemplate restTemplate;


    public OrderDto saveOrderDetails(OrderDtoFrontEnd orderDetails) {
        Integer counter=sequenceGenerator.generateNextOrderId();
       UserDto userDto= fetchUserDetailsFromUserId(orderDetails.getUserId());
        Order order=new Order(counter,orderDetails.getFoodItemList(),orderDetails.getRestaurant(),userDto);
        orderRepo.save(order);
        return OrderMapper.INSTANCE.mapOrderToOrderDto(order);
    }

    private UserDto fetchUserDetailsFromUserId(Integer userId) {
       return restTemplate.getForObject("http://USERSERVICE/userDetails/fetchById/"+userId,UserDto.class);
    }
}
