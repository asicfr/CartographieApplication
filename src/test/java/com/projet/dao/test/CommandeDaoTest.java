package com.projet.dao.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.projet.config.Application;
import com.projet.dao.CommandeDao;
import com.projet.model.Commande;

/**
 * @author only2dhir
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=Application.class)
public class CommandeDaoTest {
	
	@Autowired
	private CommandeDao commandeDao;

	@Test
	public void createCommande() {
		Commande savedCommande = commandeDao.create(getCommande());
	/*	Commande commandeFromDb = commandeDao.findCommandeById(savedCommande.getId());
		assertEquals(savedCommande.getNom(), commandeFromDb.getNom());
		assertEquals(savedCommande.getEmail(), commandeFromDb.getEmail());
	*/
	}

	@Test
	public void findAllCommandes() {
		List<Commande> commandes = commandeDao.findAll();
		assertNotNull(commandes);
		assertTrue(commandes.size() > 0);
	}

	@Test
	public void findCommandeById() {
		Commande commande = commandeDao.findCommandeById("AJ001");
		assertNotNull(commande);
	}
	
	private Commande getCommande() {
		Commande commande = new Commande();
		commande.setId("CJ001");
		commande.setClientId(1);
		commande.setProduitId("CS001");
		return commande;
	}
	
	@Test
	public void updateCommande() {
		Commande commande = new Commande();
		commande.setId("AJ001");
		commande.setClientId(1);
		commande.setProduitId("CS001");
		commande.setDateCommande("2017-12-19");
		
		commandeDao.updateCommande(commande);
	}
	
	@Test
	public void deleteCommande() {
		String id = "CJ001";
		commandeDao.deleteCommande(id);
	}
}
