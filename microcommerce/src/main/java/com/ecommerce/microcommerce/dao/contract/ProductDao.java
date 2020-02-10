package com.ecommerce.microcommerce.dao.contract;

import java.util.List;

import com.ecommerce.microcommerce.model.Product;

public interface ProductDao {
	public List<Product> findAll();
	
	public Product findById( Long id );
	
	public Product save( Product product );
	
	
}
