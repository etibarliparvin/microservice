package com.example.p12;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CashFlowDto {
    String incoming;
    String fee;
    String receivable;
    String amount;
    String currency;
    String reserve;
}
