package com.example.p12;

import lombok.Data;

import java.util.List;

@Data
public class OrderListDto {

   private List<OrderRestResponseDto> orders;
}
