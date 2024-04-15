package com.personalize.api.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class ShopperProductList {
    @Id
    private String shopperId;
    @OneToMany(cascade = CascadeType.ALL)
    private List<ProductItem> shelf;
    


}
