package com.projet.dao;

import java.util.List;

import com.projet.model.Client;

/**
 * @author only2dhir
 *
 */
public interface ClientDao {

	public Client create(final Client user);

	public List<Client> findAll();

	public Client findClientById(String id);

}
