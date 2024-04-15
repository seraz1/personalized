package com.personalize.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.personalize.api.entity.Product;
import com.personalize.api.entity.ShopperProductList;
import com.personalize.api.repository.ProductRepository;
import com.personalize.api.repository.ShopperProductListRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductService {
	private ShopperProductListRepository productListRepository;

	private ProductRepository metadataRepository;

	@Transactional
	public void saveShopperProductList(ShopperProductList productList) {
		productListRepository.save(productList);
	}

	public List<Product> getProductsByShopperId(String shopperId, String category, String brand, Integer limit) {
		// Implement query based on parameters
		return metadataRepository.findProductsByShopper(shopperId, category, brand,limit);
	}

	public void saveProduct(Product product) {
		// TODO Auto-generated method stub

	}
}
