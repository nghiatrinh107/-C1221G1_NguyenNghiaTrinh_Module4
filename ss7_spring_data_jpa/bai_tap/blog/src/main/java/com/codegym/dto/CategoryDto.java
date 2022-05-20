package com.codegym.dto;

import javax.validation.constraints.NotBlank;

public class CategoryDto {
    @NotBlank(message = "not null")
    private Integer id;
    @NotBlank(message = "not null")
    private String name;

    public CategoryDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
