package com.example.demoProject.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.example.demoProject.model.Product;

public interface ProductRepo extends CrudRepository<Product,Integer>{

	List<Product> findByBrand(String brand);
	List<Product> findByPriceGreaterThan(float price);
	List<Product> findBySize(int size);
	List<Product> findByColor(String color);
	List<Product> findBySeller(String seller);
}
