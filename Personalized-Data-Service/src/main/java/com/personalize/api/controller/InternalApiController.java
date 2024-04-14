package com.personalize.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.personalize.api.dto.ProductDTO;
import com.personalize.api.entity.Product;
import com.personalize.api.entity.ShopperProductList;
import com.personalize.api.exceptions.InvalidRequestException;
import com.personalize.api.service.ProductService;

@RestController
@RequestMapping("/internal")
public class InternalApiController {
	@Autowired
	private ProductService productService;

	@PostMapping("/product-list")
	public ResponseEntity<Void> receiveShopperProductList(@RequestBody ShopperProductList productList) {
		productService.saveShopperProductList(productList);
		return ResponseEntity.ok().build();
	}

	@PostMapping("/save")
	public ResponseEntity<String> saveProduct(@RequestBody ProductDTO productDTO) {
		try {
			
			if (productDTO.getCategory() == null || productDTO.getBrand() == null) {
	            throw new InvalidRequestException("Product name and price are required");
	        }
			Product product = new Product();
			product.setProductId(productDTO.getProductId());
			product.setCategory(productDTO.getCategory());
			product.setBrand(productDTO.getBrand());

			productService.saveProduct(product);

			return ResponseEntity.status(HttpStatus.CREATED).body("Product saved successfully");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save product");
		}
	}
}
