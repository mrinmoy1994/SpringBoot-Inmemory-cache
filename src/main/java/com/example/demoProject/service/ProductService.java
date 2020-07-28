package com.example.demoProject.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demoProject.dao.ProductRepo;
import com.example.demoProject.model.Product;
import com.example.demoProject.model.SearchModel;
import com.example.demoProject.util.ProductCache;

@Service
public class ProductService {

	@Autowired
	ProductRepo repo;
	
	@Autowired
	ProductCache cache;
	
	public Product add(Product p) {
		String s = p.getBrand().toUpperCase().charAt(0)+"-"+
				p.getType().toUpperCase().charAt(0)+"-"+
				p.getColor().toUpperCase().charAt(0)+"-"+
				p.getSize()+"-"+
				p.getSeller().toUpperCase()+"-"+
				(int)p.getPrice()+"-"+ProductCache.list.size();
		p.setSKU(s);
		p = repo.save(p);
		cache.updateList();
		return p;
	}
	
	public int remove(int id) {
		
		Optional<Product> p = repo.findById(id);
		if(p.isPresent()) {
			repo.deleteById(id);
			cache.updateList();
			return 0;
		}
		
		return -1;
	}
	
	public List<Product> getProduct(SearchModel model)
	{
		return ProductCache.list.stream().filter(x->{
			return model.matchBrand(x.getBrand()) && model.matchColor(x.getColor()) && model.matchPrice(x.getPrice()) && model.matchSeller(x.getSeller()) && model.matchSize(x.getSize()) && model.matchType(x.getType())&& model.matchSku(x.getSKU());
		}).collect(Collectors.toList());
	}
}
