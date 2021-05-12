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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Temporal(TemporalType.DATE)
    private Date date;

    @Column
    private String expertises;

    @Column
    private String message;

    @Column(name = "CLIENT_ID")
    private Integer clientId;

    @ManyToOne
    @JoinColumn(name = "ID_CLIENT", insertable = false, updatable = false)
    private Client client;

    protected Devis() {
    }

    public Devis(Date date, String expertises, String message) {
	this.date = date;
	this.expertises = expertises;
	this.message = message;
    }

    @Override
    public String toString() {
	return String.format("Devis[id=%d, date='%s', experties='%s', message='%s']", id, date, expertises, message);
    }
}