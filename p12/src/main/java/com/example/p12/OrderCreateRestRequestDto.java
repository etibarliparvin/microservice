package com.example.p12;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@Builder
@FieldDefaults(level= AccessLevel.PRIVATE)
public class OrderCreateRestRequestDto {
    BigDecimal amount;
    ClientRequestDto client;
    OptionsDto options;
}
