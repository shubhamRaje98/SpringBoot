package com.api.dto;

import jakarta.persistence.Id;

import java.time.LocalDate;

public class ProductDTO {

    private Integer productId;

    private String productName;

    private String productDescription;

    private LocalDate expDate;

    public void setProductId(Integer productId){
        this.productId = productId;
    }

    public void setProductName(String productName){
        this.productName = productName;
    }
    public void setProductDescription(String productDescription){
        this.productDescription = productDescription;
    }
    public void setExpDate(LocalDate expDate){
        this.expDate = expDate;
    }

    public Integer getProductId(){
        return this.productId;
    }

    public String getProductName(){
        return this.productName;
    }

    public String getProductDescription(){
        return this.productDescription;
    }

    public LocalDate getExpDate(){
        return this.expDate;
    }
    @Override
    public String toString() {
        return this.productName;
    }
}
