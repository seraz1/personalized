package com.personalize.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.personalize.api.entity.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
}
