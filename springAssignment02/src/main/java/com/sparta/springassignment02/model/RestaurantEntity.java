package com.sparta.springassignment02.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class RestaurantEntity extends Timestamped{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // 음식점 ID
    private String name; //음식점 이름
    @Max(value = 100000, message ="최소주문 가격은 10만원을 넘을 수 없습니다.")
    @Min(value = 1000, message ="최소주문 가격은 1000원 보다 적을 수 없습니다.")
    @PositiveOrZero
    private int minOrderPrice; //최소주문 가격
    @Max(value = 10000, message = "배달비는 1만원을 넘을 수 없습니다.")
    @PositiveOrZero(message = "0원과 음수를 입력할 수 없습니다.")
    private int deliveryFee; //기본 배달비
}
