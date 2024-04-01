package com.dk.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodItemDto {
    private int id;
    private String itemName;
    private String itemDesc;
    private boolean isVeg;
    private Number price;
    private Integer restaurantId;
    private Integer quantity;
}
