package com.sparta.springassignment02.service;


import com.sparta.springassignment02.dto.RestaurantDTO;
import com.sparta.springassignment02.model.RestaurantEntity;
import com.sparta.springassignment02.persistence.RestaurantRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository repository;

    public String create(final RestaurantEntity entity){
        validate(entity);
        repository.save(entity);
        log.info("Entity Name : {} is saved", entity.getName());
        return entity.getName();

    }
    private void validate(final RestaurantEntity entity){
        if(entity == null){
            log.warn("Entity cannot be null");
            throw new RuntimeException("Entity cannot be null.");
        }
        if(entity.getMinOrderPrice() % 100 != 0){
            log.warn("최소 주문 가격은 100원 단위만 입력 가능합니다.");
            throw new RuntimeException("최소 주문 가격은 100원 단위만 입력 가능합니다.");
        }
        if(entity.getDeliveryFee() % 500 != 0){
            log.warn("기본 배달비는 500원 단위만 입력 가능합니다.");
            throw new RuntimeException("기본 배달비는 500원 단위만 입력 가능합니다.");
        }
    }
}
