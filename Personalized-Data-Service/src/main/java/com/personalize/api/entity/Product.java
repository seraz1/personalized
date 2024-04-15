package com.personalize.api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Product {
    @Id
    private String productId;
    private String category;
    private String brand;


    
}

