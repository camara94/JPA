package com.ecommerce.microcommerce.model;

public class Product {
	
	private Long id;
	private String nom;
	private double prix;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(Long id, String nom, double prix) {
		super();
		this.id = id;
		this.nom = nom;
		this.prix = prix;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	
	

}
