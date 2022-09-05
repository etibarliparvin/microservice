package com.example.p12;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ClientRequestDto {
    String address;
    String city;
    String country;
    String email;
    String name;
    String phone;
    String state;
    String zip;
}
