package com.example.p12;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class OperationDto {
    String type;
    String iso_message;
    String created;
    String amount;
    String auth_code;
    String iso_response_code;
    CashFlowDto cashflow;
    String currency;
    String status;
    String arn;
}
