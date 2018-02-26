package com.projet.model;

import java.util.ArrayList;
import java.util.List;

public class Commande {
	private int numero;
	private String id;
	private int client_id;
	private String date_commande;
	private float prix_total;
	private List<Commande> commande_id;
	
	
	
	public Commande(int numero, int client_id, String commande_id, String date_commande) {
		super();
		this.numero = numero;
		this.client_id = client_id;
		this.commande_id = new ArrayList<Commande>();
		this.date_commande = date_commande;
	}
	
	public int getNumero() {
		return numero;
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public int getClientId() {
		return client_id;
	}
	
	public void setClientId(int client_id) {
		this.client_id = client_id;
	}
	
	public String getProduitId() {
		return commande_id;
	}
	
	public void setProduitId(String produit_id) {
		this.commande_id = produit_id;
	}
	
	public String getDateCommande() {
		return date_commande;
	}
	
	public void setDateCommande(String date_commande) {
		this.date_commande = date_commande;
	}
	
}
