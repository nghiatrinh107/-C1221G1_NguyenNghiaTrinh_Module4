package com.codegym.dto;

import com.codegym.model.Category;

import javax.validation.constraints.NotNull;


public class ProductDto {

    private Integer id;
    @NotNull(message = "Not null")
    private String name;
    private Integer price;
    private String description;
    private String manufacturer;
    private Category category;
}
