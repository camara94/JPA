package com.ecommerce.microcommerce.controller;


import java.net.URI;
import java.net.URL;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@PostMapping(value="/produits")
	public ResponseEntity<Void>  addProduit(@RequestBody Product product ) {
		
		Product produit = productDao.save(product);
		
		if ( product == null ) {
			
			return ResponseEntity.noContent().build();
		}
		
		URI location = ServletUriComponentsBuilder
						.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand( produit.getId() )
						.toUri();
		//return productDao.save(product);
		
		return ResponseEntity.created(location).build();
						
	}
	
}
