package com.codegym.model;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nameProduct;
    private Integer price;
    private String description;
    private String manufacturer;

    public Product() {
    }

    public Product(Integer id, String nameProduct, Integer price, String description, String manufacturer) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.price = price;
        this.description = description;
        this.manufacturer = manufacturer;
    }

    public Product(String nameProduct, Integer price, String description, String manufacturer) {
        this.nameProduct = nameProduct;
        this.price = price;
        this.description = description;
        this.manufacturer = manufacturer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}
