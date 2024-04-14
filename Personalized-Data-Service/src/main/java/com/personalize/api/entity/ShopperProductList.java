package com.personalize.api.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class ShopperProductList {
    @Id
    private String shopperId;
    @OneToMany(cascade = CascadeType.ALL)
    private List<ProductItem> shelf;
    
	public String getShopperId() {
		return shopperId;
	}
	public void setShopperId(String shopperId) {
		this.shopperId = shopperId;
	}
	public List<ProductItem> getShelf() {
		return shelf;
	}
	public void setShelf(List<ProductItem> shelf) {
		this.shelf = shelf;
	}
    
    
}
