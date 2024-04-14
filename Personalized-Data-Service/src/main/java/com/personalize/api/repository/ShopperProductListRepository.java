package com.personalize.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.personalize.api.entity.ShopperProductList;
@Repository
public interface ShopperProductListRepository extends JpaRepository<ShopperProductList, String>{
}
