package com.dk.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private Integer orderId;
    private List<FoodItemDto> foodItemList;
    private Restaurant restaurant;
    private UserDto userDto;
}
