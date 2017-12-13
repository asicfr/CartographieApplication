package com.projet.model;

public class Client {

	private int id;
	private String nom;
    private String prenom;
    private String date_naissance;
    private String e_mail;

    public void setId(int id) {
		this.id = id;
	}
    
    public int getId() {
		return id;
	}

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

	public String getDateNaissance() {
		return date_naissance;
	}

	public void setDateNaissance(String date_naissance) {
		this.date_naissance = date_naissance;
	}

    public String getEmail() {
        return e_mail;
    }

    public void setEmail(String e_mail) {
        this.e_mail = e_mail;
    }

}
