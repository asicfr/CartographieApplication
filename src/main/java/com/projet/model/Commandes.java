package com.projet.model;

public class Commandes {
	private String id;
	private String client_id;
	private String produit_id;
	private String date_commande;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getClient_id() {
		return client_id;
	}
	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}
	public String getProduit_id() {
		return produit_id;
	}
	public void setProduit_id(String produit_id) {
		this.produit_id = produit_id;
	}
	public String getDate_commande() {
		return date_commande;
	}
	public void setDate_commande(String date_commande) {
		this.date_commande = date_commande;
	}
}
