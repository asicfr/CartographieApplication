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
import com.projet.dao.ClientDao;
import com.projet.model.Client;

/**
 * @author only2dhir
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=Application.class)
public class ClientDaoTest {

	@Autowired
	private ClientDao clientDao;

	@Test
	public void createClient() {
		Client savedClient = clientDao.create(getClient());
		Client clientFromDb = clientDao.findClientById(savedClient.getId());
		assertEquals(savedClient.getNom(), clientFromDb.getNom());
		assertEquals(savedClient.getEmail(), clientFromDb.getEmail());
	}

	@Test
	public void findAllClients() {
		List<Client> clients = clientDao.findAll();
		assertNotNull(clients);
		assertTrue(clients.size() > 0);
	}

	@Test
	public void findClientById() {
		Client client = clientDao.findClientById("BK001");
		assertNotNull(client);
	}
	
	private Client getClient() {
		Client client = new Client();
		client.setId("BK001");
		client.setNom("Doe");
		client.setPrenom("John");
		client.setDateNaissance("11/03/1990");
		client.setEmail("johndoe@gmail.com");
		return client;
	}

}