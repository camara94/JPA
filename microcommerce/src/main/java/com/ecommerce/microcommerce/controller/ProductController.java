package com.ecommerce.microcommerce.controller;


import java.net.URI;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
		
		return productDao.getProductById( id );
	}
	
	
	@RequestMapping( value="produits", method = RequestMethod.POST)
	@Transactional
	public ResponseEntity<Void>  addProduit(@RequestBody Product product ) {
		
		Product produit = productDao.save(product);
		
		if ( produit == null ) {
			
			return ResponseEntity.noContent().build();
		}
		
		URI location = ServletUriComponentsBuilder
						.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand( produit.getId() )
						.toUri();
		
		return ResponseEntity.created(location).build();
						
	}
	
	@RequestMapping( value="produits/{id}", method = RequestMethod.DELETE)
	@Transactional
	//@DeleteMapping (value = "/Produits/{id}")
	   public void supprimerProduit(@PathVariable Long id) {

	       productDao.deleteById(id);
	 }
	
	@GetMapping(value = "test/produits/{recherche}")
    public List<Product> testeDeRequetes(@PathVariable String recherche) {
        return productDao.findByNomLike("%"+recherche+"%");
    }
	
	@PutMapping( value = "produits/{id}" )
	@Transactional
	public ResponseEntity<Product> updateProduit( @PathVariable Long id , @RequestBody Product product ) {
		Product produit = productDao.getProductById(id);
		
		if ( produit == null ) {
			return ResponseEntity.noContent().build();
		}
		
		produit.setNom( product.getNom() );
		produit.setPrix( product.getPrix() );
		produit.setPrixAchat( product.getPrixAchat() );
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand( produit.getId() )
				.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
}
