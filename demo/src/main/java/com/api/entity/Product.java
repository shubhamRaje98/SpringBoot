package com.api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Product {

    @Id
    private Integer productId;

    private String productName;

    private String productDescription;

    private LocalDateTime expDate;

    public void setProductId(Integer productId){
        this.productId = productId;
    }

    public void setProductName(Integer productId){
        this.productId = productId;
    }
    public void setProductDescription(Integer productId){
        this.productId = productId;
    }
    public void setExpDate(Integer productId){
        this.productId = productId;
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

    public LocalDateTime getExpDate(){
        return this.expDate;
    }

}
