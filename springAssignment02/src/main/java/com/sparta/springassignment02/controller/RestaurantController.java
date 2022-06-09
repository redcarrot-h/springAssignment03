package com.sparta.springassignment02.controller;

import com.sparta.springassignment02.dto.RestaurantDTO;
import com.sparta.springassignment02.model.RestaurantEntity;
import com.sparta.springassignment02.persistence.RestaurantRepository;
import com.sparta.springassignment02.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class RestaurantController {

    private final RestaurantRepository restaurantRepository;
    @Autowired
    private RestaurantService restaurantService;

    //음식점 등록
    @PostMapping("restaurant/register")
    public RestaurantEntity create(@RequestBody RestaurantDTO dto){
        RestaurantEntity entity = RestaurantDTO.TorestaurantEntity(dto);
        restaurantService.create(entity);
        return entity;
    }

    //음식점 조회
    @GetMapping("restaurants")
    public List<RestaurantEntity> readRestaurant(){
        return restaurantRepository.findAllByOrderByCreatedAtDesc();
    }

}
