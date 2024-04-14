package com.personalize.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personalize.api.entity.Product;
import com.personalize.api.entity.ShopperProductList;
import com.personalize.api.repository.ProductMetadataRepository;
import com.personalize.api.repository.ShopperProductListRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductService {
	@Autowired
	private ShopperProductListRepository productListRepository;

	@Autowired
	private ProductMetadataRepository metadataRepository;

	@Transactional
	public void saveShopperProductList(ShopperProductList productList) {
		productListRepository.save(productList);
	}

	public List<Product> getProductsByShopperId(String shopperId, String category, String brand, Integer limit) {
		// Implement query based on parameters
		return metadataRepository.findProductsByShopper(shopperId, category, brand);
	}

	public void saveProduct(Product product) {
		// TODO Auto-generated method stub

	}
}
