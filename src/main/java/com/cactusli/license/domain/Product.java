package com.cactusli.license.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private String code;
    private String fallbackDate;
    private String paidUpTo;
    private Boolean extended;

    public Product(String code, String date) {
        this.code = code;
        this.fallbackDate = date;
        this.paidUpTo = date;
        this.extended = true;
    }
}
