package com.sparta.springassignment02.dto;

import com.sparta.springassignment02.model.FoodEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FoodDTO {
    private Long id;
    private Long restaurantId;
    private String name; //음식이름
    private int price; //음식가격

    public FoodDTO(final FoodEntity entity){
        this.id = entity.getId();
        this.restaurantId = entity.getRestaurantId();
        this.name = entity.getName();
        this.price= entity.getPrice();
    }

    public static FoodEntity ToFoodEntity(final FoodDTO dto){
        return FoodEntity.builder()
                .id(dto.getId())
                .name(dto.getName())
                .price(dto.getPrice())
                .build();
    }

    public static FoodEntity ToFoodEntity(final FoodDTO dto, Long restaurantId){
        return FoodEntity.builder()
                .id(dto.getId())
                .restaurantId(restaurantId)
                .name(dto.getName())
                .price(dto.getPrice())
                .build();
    }

}
