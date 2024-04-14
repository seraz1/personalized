package com.personalize.api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ProductItem {
    @Id
    private String productId;
    private Double relevancyScore;
    
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public Double getRelevancyScore() {
		return relevancyScore;
	}
	public void setRelevancyScore(Double relevancyScore) {
		this.relevancyScore = relevancyScore;
	}
    
}
