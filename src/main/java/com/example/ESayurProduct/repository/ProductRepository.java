package com.example.ESayurProduct.repository;

import com.example.ESayurProduct.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long>,ProductRepositoryCustom {


}
