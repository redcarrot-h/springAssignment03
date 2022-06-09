package com.sparta.springassignment02.controller;

import com.sparta.springassignment02.dto.FoodDTO;
import com.sparta.springassignment02.model.FoodEntity;
import com.sparta.springassignment02.persistence.FoodRepository;
import com.sparta.springassignment02.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("restaurant")
public class FoodController {

    private final FoodRepository foodRepository;
    @Autowired
    private FoodService foodService;

    //음식 등록
    @PostMapping("/{restaurantid}/food/register")
    public FoodEntity create(@PathVariable("restaurantid") Long restaurantid, @RequestBody FoodDTO dto){
        FoodEntity entity = foodService.create(dto, restaurantid);
        return entity;
    }

    @GetMapping("/{restaurantid}/foods")
    public List<FoodEntity> readFood(@PathVariable Long restaurantid){
        return foodRepository.findByRestaurantId(restaurantid);
    }


}
