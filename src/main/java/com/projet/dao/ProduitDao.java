package com.projet.dao;

import java.util.List;

import com.projet.model.Produit;

public interface ProduitDao {

	public Produit create(final Produit produit);

	public List<Produit> findAll();

	public Produit findProduitById(int id);
	
	public void updateProduit (Produit produit);
	
	public void deleteProduit (String id);

}
