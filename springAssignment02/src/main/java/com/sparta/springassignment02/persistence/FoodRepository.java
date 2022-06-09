package com.sparta.springassignment02.persistence;

import com.sparta.springassignment02.model.FoodEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends JpaRepository<FoodEntity, Long> {
    List<FoodEntity> findByRestaurantId(Long restaurantId);
}
