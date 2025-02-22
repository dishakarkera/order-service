package com.dk.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDtoFrontEnd {

private List<FoodItemDto> foodItemList;
private Integer userId;
private Restaurant restaurant;

}
