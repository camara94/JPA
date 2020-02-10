package com.ecommerce.microcommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//Pour cacher plusieurs propriétés
@JsonIgnoreProperties( value = { "prix", "id" } )
public class Product {
	
	private Long id;
	private String nom;
	private double prix;
	//Pour cacher une propriété
	//@JsonIgnore
	private double prixAchat;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(Long id, String nom, double prix, double prixAchat) {
		super();
		this.id = id;
		this.nom = nom;
		this.prix = prix;
		this.prixAchat = prixAchat;
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

	public double getPrixAchat() {
		return prixAchat;
	}

	public void setPrixAchat(double prixAchat) {
		this.prixAchat = prixAchat;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", nom=" + nom + ", prix=" + prix + ", prixAchat=" + prixAchat + "]";
	}
	

}
