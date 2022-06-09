package com.sparta.springassignment02.dto;

import com.sparta.springassignment02.model.RestaurantEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RestaurantDTO {
    private Long id;
    private String name;
    private int minOrderPrice;
    private int deliveryFee;

    public RestaurantDTO(final RestaurantEntity entity){
        this.id = entity.getId();
        this.name = entity.getName();
        this.minOrderPrice = entity.getMinOrderPrice();
        this.deliveryFee = entity.getDeliveryFee();
    }

    public static RestaurantEntity TorestaurantEntity(final RestaurantDTO dto){
        return RestaurantEntity.builder()
                .id(dto.getId())
                .name(dto.getName())
                .minOrderPrice(dto.getMinOrderPrice())
                .deliveryFee(dto.getDeliveryFee())
                .build();
    }
}
