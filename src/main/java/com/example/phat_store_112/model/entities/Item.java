package com.example.phat_store_112.model.entities;

import lombok.Data;

@Data
public class Item extends BaseEntity {
    private String model;
    private Integer price;
    private Integer amount;
    private String size;
    private String color;
    private Integer brandId;
    private Integer categoryId;
}
