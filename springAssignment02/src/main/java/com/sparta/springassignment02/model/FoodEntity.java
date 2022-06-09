package com.sparta.springassignment02.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "name")})
public class FoodEntity extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // 음식 ID
    private Long restaurantId;
    private String name; //음식이름
    @Max(value = 1000000, message ="가격은 100만원을 넘을 수 없습니다.")
    @Min(value = 100, message ="가격은 100원 보다 적을 수 없습니다.")
    private int price; //음식가격

}
