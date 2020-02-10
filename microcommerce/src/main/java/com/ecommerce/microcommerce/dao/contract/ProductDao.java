package com.ecommerce.microcommerce.dao.contract;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecommerce.microcommerce.model.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Long> {
	
	public Product getProductById(Long id);
	List<Product> findByNomLike(String recherche);
	@Query("SELECT id, nom, prix FROM Product p WHERE p.prix > :prixLimit")
	List<Product>  chercherUnProduitCher(@Param("prixLimit") double prix);
}
