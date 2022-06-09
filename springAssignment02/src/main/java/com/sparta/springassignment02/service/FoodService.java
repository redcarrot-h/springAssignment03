package com.sparta.springassignment02.service;

import com.sparta.springassignment02.dto.FoodDTO;
import com.sparta.springassignment02.model.FoodEntity;
import com.sparta.springassignment02.model.RestaurantEntity;
import com.sparta.springassignment02.persistence.FoodRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class FoodService {
    @Autowired
    private FoodRepository repository;

    public FoodEntity create(FoodDTO dto, Long restaurantId){
        FoodEntity entity = FoodDTO.ToFoodEntity(dto, restaurantId);
        System.out.println(entity);
        validate(entity);
        repository.save(entity);
        log.info("Entity Name : {} is saved", entity.getName());
        return entity;

    }

    private void validate(final FoodEntity entity){
        if(entity.getRestaurantId() == null){
            log.warn("RestaurantId cannot be null");
            throw new RuntimeException("RestaurantId of Entity cannot be null.");
        }
        if(entity.getPrice() % 100 != 0){
            log.warn("최소 주문 가격은 100원 단위만 입력 가능합니다.");
            throw new RuntimeException("최소 주문 가격은 100원 단위만 입력 가능합니다.");
        }
    }


}
