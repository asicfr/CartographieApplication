package com.projet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projet.dao.ClientDao;
import com.projet.model.Client;

@RestController
public class ClientController {

    @Autowired
    ClientDao clientDAO;

    @RequestMapping("/client")
    public List<Client> client() {
    	List<Client> lesClients = clientDAO.findAll();
        return lesClients;
    }
}