package com.projet.dao.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.projet.dao.ProduitDao;
import com.projet.model.Produit;

public class ProduitDaoTest {
	@Autowired
	private ProduitDao produitDao;

	@Test
	public void createProduit() {
		Produit savedProduit = produitDao.create(getProduit());
	/*	Produit produitFromDb = produitDao.findProduitById(savedProduit.getId());
		assertEquals(savedProduit.getNom(), produitFromDb.getNom());
		assertEquals(savedProduit.getEmail(), produitFromDb.getEmail());
	*/
	}

	@Test
	public void findAllProduits() {
		List<Produit> produits = produitDao.findAll();
		assertNotNull(produits);
		assertTrue(produits.size() > 0);
	}

	@Test
	public void findProduitById() {
		Produit produit = produitDao.findProduitById(1);
		assertNotNull(produit);
	}
	
	private Produit getProduit() {
		Produit produit = new Produit();
		produit.setId("AS001");
		produit.setTitre("Asirateur");
		produit.setPrix(50.19);
		return produit;
	}
	
	@Test
	public void updateProduit() {
		Produit produit = new Produit();
		produit.setId("AS001");
		produit.setTitre("Aspirateur");
		produit.setPrix(49.99);
		
		produitDao.updateProduit(produit);
	}
	
	@Test
	public void deleteProduit() {
		String id = "AS001";
		produitDao.deleteProduit(id);
	}
}
