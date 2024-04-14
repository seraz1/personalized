package com.personalize.api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ProductMetadata {
    @Id
    private String productId;
    private String category;
    private String brand;
    
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
    
}
