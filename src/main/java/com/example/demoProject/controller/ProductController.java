package com.example.demoProject.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.demoProject.model.Product;
import com.example.demoProject.model.SearchModel;
import com.example.demoProject.service.ProductService;


@RestController
@RequestMapping("product")
public class ProductController {
	@Autowired
	ProductService service;

	/*
	 * Name : addProduct
	 * Functionality : Adding product
	 * Parameter(s) : Object reference of a product, which needs to be added
	 */
	@RequestMapping(method=RequestMethod.POST,value="add")
	public ResponseEntity<Product> addProduct(@RequestBody Product p)
	{
		if((p.getBrand()==null || p.getBrand().trim().equalsIgnoreCase("")) ||
				(p.getType()==null || p.getType().trim().equalsIgnoreCase("")) ||
				(p.getColor()==null || p.getColor().trim().equalsIgnoreCase("")) ||
				(p.getSize() == 0) ||
				(p.getSeller()==null || p.getSeller().trim().equalsIgnoreCase("")) ||
				(p.getPrice()==0.0))
		{
			return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
		}
		
		p= service.add(p);
		return new ResponseEntity<Product>(p,HttpStatus.OK);
	}
	
	/*
	 * Name : removeProduct
	 * Functionality : removing/purchasing product
	 * Parameter(s) : id of a product, which needs to be removed
	 */
	@RequestMapping(method=RequestMethod.DELETE,value="remove/{id}")
	public ResponseEntity<Object> removeProduct(@PathVariable("id") int id)
	{
		int res = service.remove(id);
		if(res==-1)
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	/*
	 * Name : getProduct
	 * Functionality : searchs and provides list products depending on various search queries
	 * Parameter(s) : Object reference of a SearchModel, which contains all the requirements for searching
	 */
	@RequestMapping(method=RequestMethod.POST,value="search")
	public ResponseEntity<List<Product>> getProduct(@RequestBody SearchModel model)
	{
		return new ResponseEntity<List<Product>>(service.getProduct(model),HttpStatus.OK);
	}
}