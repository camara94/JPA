package com.ecommerce.microcommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.microcommerce.dao.contract.ProductDao;
import com.ecommerce.microcommerce.model.Product;

@RestController
public class ProductController {
	
	@Autowired
	private ProductDao productDao;
	
	@GetMapping( value="produits")
	public List<Product> listProduits() {
		return productDao.findAll();
	}

	@GetMapping( value="produits/{id}" )
	public Product afficheUnProduit( @PathVariable Long id ) {
		
		return productDao.findById(id);
	}
	
}
