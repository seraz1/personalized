package com.personalize.api.controller;

import org.modelmapper.ModelMapper;
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

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/internal")
@AllArgsConstructor
public class InternalApiController {
	
	private ProductService productService;
	private ModelMapper modelMapper;

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
			
			Product product =modelMapper.map(productDTO, Product.class);
			
			productService.saveProduct(product);

			return ResponseEntity.status(HttpStatus.CREATED).body("Product saved successfully");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save product");
		}
	}
}
