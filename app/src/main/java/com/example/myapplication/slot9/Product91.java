package com.example.myapplication.slot9;
//
public class Product91 {
    private String styleId;
    private String brand;
    private String price;
    private String searchImage;

    public Product91() {
    }

    public Product91(String styleId, String brand, String price, String searchImage) {
        this.styleId = styleId;
        this.brand = brand;
        this.price = price;
        this.searchImage = searchImage;
    }

    public String getStyleId() {
        return styleId;
    }

    public void setStyleId(String styleId) {
        this.styleId = styleId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSearchImage() {
        return searchImage;
    }

    public void setSearchImage(String searchImage) {
        this.searchImage = searchImage;
    }
}
