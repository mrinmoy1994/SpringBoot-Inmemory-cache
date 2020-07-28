package com.example.demoProject.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.demoProject.dao.ProductRepo;
import com.example.demoProject.model.Product;

@Component
public class ProductCache {
	
	@Autowired
	private transient ProductRepo repo;
	public static List<Product> list = null;
	
	@Scheduled(fixedRate=7200000)
	public void updateList() {
		list = (List<Product>) repo.findAll();
		//System.out.println("cache : "+list);
	}
	
	
}
