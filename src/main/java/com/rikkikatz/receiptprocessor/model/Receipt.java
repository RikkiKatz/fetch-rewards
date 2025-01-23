package com.rikkikatz.receiptprocessor.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Receipt {

    private String retailer;
    private LocalDate purchaseDate;
    private LocalTime purchaseTime;
    private List<Item> items;
    private String total;
   
}
