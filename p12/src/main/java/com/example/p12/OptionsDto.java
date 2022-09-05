package com.example.p12;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OptionsDto implements Serializable {
    final String returnUrl = "https://ozpay.vercel.app/success";
    final int auto_charge = 1;
}
