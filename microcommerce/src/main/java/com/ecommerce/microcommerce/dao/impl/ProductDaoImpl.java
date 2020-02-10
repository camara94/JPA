package com.ecommerce.microcommerce.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ecommerce.microcommerce.dao.contract.ProductDao;
import com.ecommerce.microcommerce.model.Product;

@Repository
public class ProductDaoImpl implements ProductDao {
	
	public static List<Product> products = new ArrayList<>();
	
	static {
		products.add(new Product(1L, "Ordinateur", 350, 300));
		products.add(new Product(2L, "Aspirateur", 500, 450));
		products.add(new Product(3L, "Table de Ping", 750, 700));
		products.add(new Product(4L, "Téléphone", 200, 150));
	}

	@Override
	public List<Product> findAll() {
		return products;
	}

	@Override
	public Product findById(Long id) {
		
		Product product = new Product();
		
		for( int i=0; i < products.size(); i++ ) {
			if (id == products.get(i).getId() )
			{
				product = products.get(i);
			}
		}
		
		return product;
	}

	@Override
	public Product save(Product product) {
		products.add(product);
		return product;
	}

}
