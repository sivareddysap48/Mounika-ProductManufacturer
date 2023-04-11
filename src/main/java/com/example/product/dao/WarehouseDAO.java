package com.example.product.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.product.model.WarehouseProduct;

@Repository
public interface WarehouseDAO extends JpaRepository<WarehouseProduct, Integer> {

}
