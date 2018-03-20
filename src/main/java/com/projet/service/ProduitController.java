package com.projet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projet.dao.ProduitDao;
import com.projet.model.Produit;

@RestController
public class ProduitController {

    @Autowired
    ProduitDao produitDAO;

    @RequestMapping("/produit")
    public List<Produit> produit() {
    	List<Produit> lesProduits = produitDAO.findAll();
        return lesProduits;
    }
}