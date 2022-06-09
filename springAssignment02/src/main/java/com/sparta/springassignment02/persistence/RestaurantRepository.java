package com.sparta.springassignment02.persistence;

import com.sparta.springassignment02.model.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RestaurantRepository extends JpaRepository<RestaurantEntity, Long> {
    List<RestaurantEntity> findAllByOrderByCreatedAtDesc();
}
