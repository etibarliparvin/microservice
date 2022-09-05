package com.example.p12;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderRestResponseDto {

    String id;
    String created;
    String merchant_order_id;
    String amount;
    String status;
    String updated;
    String amount_charged; // fee
    String pan;
    String currency;
    String amount_refunded;
    String auth_code;
    CardDto card;
    ClientDto client;
    String description;
    String descriptor;
    IssuerDto issuer;
    //    LocationDto location;
    List<OperationDto> operations;
    String segment;
    String checkoutUrl;
}
