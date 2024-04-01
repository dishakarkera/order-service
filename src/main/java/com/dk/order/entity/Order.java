package com.dk.order.entity;

import com.dk.order.dto.FoodItemDto;
import com.dk.order.dto.Restaurant;
import com.dk.order.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("order")
public class Order {
    private Integer orderId;
    private List<FoodItemDto> foodItemDtoList;
    private Restaurant restaurant;
    private UserDto userDto;
}
