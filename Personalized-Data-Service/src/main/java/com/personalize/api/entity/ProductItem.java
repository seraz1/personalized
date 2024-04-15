package com.personalize.api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class ProductItem {
    @Id
    private String productId;
    private Double relevancyScore;
    


}
