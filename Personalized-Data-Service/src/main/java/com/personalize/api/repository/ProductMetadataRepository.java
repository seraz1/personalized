package com.personalize.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.personalize.api.entity.Product;
import com.personalize.api.entity.ProductMetadata;

@Repository
public interface ProductMetadataRepository extends JpaRepository<ProductMetadata, String> {

	@Query("SELECT p FROM Product p " + "JOIN ShopperProductList spl ON spl.shopperId = :shopperId "
			+ "JOIN spl.shelf pi ON pi.productId = p.productId "
			+ "JOIN ProductMetadata pm ON pm.productId = p.productId "
			+ "WHERE (:category IS NULL OR pm.category = :category) " + "AND (:brand IS NULL OR pm.brand = :brand)")
	List<Product> findProductsByShopper(@Param("shopperId") String shopperId, @Param("category") String category,
			@Param("brand") String brand);

}
