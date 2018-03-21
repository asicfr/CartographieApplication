package com.projet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projet.dao.ClientDao;
import com.projet.model.Client;

@RestController
public class ClientController {

    @Autowired
    ClientDao clientDAO;

    @RequestMapping(value = "/client", method = RequestMethod.POST)
    public int createClient(@RequestBody Client client) {
    	Client createdClient = clientDAO.create(client);
        return createdClient.getId();
    }
    
    @RequestMapping("/client")
    public List<Client> getAll() {
    	List<Client> lesClients = clientDAO.findAll();
        return lesClients;
    }

    @RequestMapping("/client/{id}")
    public Client getClientById(@PathVariable("id") int id) {
    	Client client = clientDAO.findClientById(id);
        return client;
    }
    
    @RequestMapping(value = "/client", method = RequestMethod.PUT)
    public void updateClient(@RequestBody Client client) {
    	clientDAO.updateClient(client);
    }
    
    @RequestMapping(value = "/client", method = RequestMethod.DELETE)
    public void deleteClient(@RequestParam("id") int id) {
    	clientDAO.deleteClient(id);
    }
    
}