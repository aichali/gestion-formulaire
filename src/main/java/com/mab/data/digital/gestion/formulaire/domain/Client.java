package com.mab.data.digital.gestion.formulaire.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Client")
public class Client implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -2790685799202043940L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client")
    private Integer idClient;

    @Column
    private String nom;

    @Column
    private String prenom;

    @Column
    private String adresse;

    @Column
    private String cp;

    @Column
    private String mail;

    @Column
    private String tel;

    @OneToMany(mappedBy = "client")
    private List<Devis> devis = new ArrayList<Devis>();

    protected Client() {
    }

    public Client(String nom, String prenom, String adresse, String cp, String mail, String tel) {
	this.nom = nom;
	this.prenom = prenom;
	this.adresse = adresse;
	this.cp = cp;
	this.mail = mail;
	this.tel = tel;
    }

    @Override
    public String toString() {
	return String.format("Client[idClient=%d, nom='%s', prenom='%s', adresse='%s', cp='%s', mail='%s', tel='%s']", idClient, nom, prenom, adresse, cp, mail,
		tel);
    }

    public Integer getIdClient() {
	return idClient;
    }

    public void setIdClient(Integer idClient) {
	this.idClient = idClient;
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

    public String getAdresse() {
	return adresse;
    }

    public void setAdresse(String adresse) {
	this.adresse = adresse;
    }

    public String getCp() {
	return cp;
    }

    public void setCp(String cp) {
	this.cp = cp;
    }

    public String getMail() {
	return mail;
    }

    public void setMail(String mail) {
	this.mail = mail;
    }

    public String getTel() {
	return tel;
    }

    public void setTel(String tel) {
	this.tel = tel;
    }

    public List<Devis> getDevis() {
	return devis;
    }

    public void setDevis(List<Devis> devis) {
	this.devis = devis;
    }
}