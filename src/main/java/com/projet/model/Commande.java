package com.projet.model;

public class Commande {
	private String id;
	private int client_id;
	private String commande_id;
	private String date_commande;
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
