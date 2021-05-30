package com.mab.data.digital.gestion.formulaire.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Devis")
public class Devis implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -4216611433473601980L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Temporal(TemporalType.DATE)
    private Date date;

    @Column
    private String expertises;

    @Column
    private String message;

    @Column(name = "id_client")
    private Integer clientId;

    @ManyToOne
    @JoinColumn(name = "id_client", insertable = false, updatable = false)
    private Client client;

    protected Devis() {
    }

    public Devis(Date date, String expertises, String message) {
	this.date = date;
	this.expertises = expertises;
	this.message = message;
    }

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public Date getDate() {
	return date;
    }

    public void setDate(Date date) {
	this.date = date;
    }

    public String getExpertises() {
	return expertises;
    }

    public void setExpertises(String expertises) {
	this.expertises = expertises;
    }

    public String getMessage() {
	return message;
    }

    public void setMessage(String message) {
	this.message = message;
    }

    public Integer getClientId() {
	return clientId;
    }

    public void setClientId(Integer clientId) {
	this.clientId = clientId;
    }

    public Client getClient() {
	return client;
    }

    public void setClient(Client client) {
	this.client = client;
    }

    @Override
    public String toString() {
	return String.format("Devis[id=%d, date='%s', experties='%s', message='%s',  clientId='%s']", id, date, expertises, message, clientId);
    }
}