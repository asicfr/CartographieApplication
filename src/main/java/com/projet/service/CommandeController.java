package com.projet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projet.dao.CommandeDao;
import com.projet.model.Commande;

@RestController
public class CommandeController {

    @Autowired
    CommandeDao commandeDAO;

    @RequestMapping("/commande")
    public List<Commande> commande() {
    	List<Commande> lesCommandes = commandeDAO.findAll();
        return lesCommandes;
    }
}