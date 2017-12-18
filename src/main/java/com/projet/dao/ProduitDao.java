package com.projet.dao;

import java.util.List;

import com.projet.model.Produit;

/**
 * @author only2dhir
 *
 */
public interface ProduitDao {

	public Produit create(final Produit produit);

	public List<Produit> findAll();

	public Produit findProduitById(String id);
	
	public void updateProduit (Produit produit);
	
	public void deleteProduit (String id);

}
