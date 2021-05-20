package com.mab.data.digital.gestion.formulaire.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mab.data.digital.gestion.formulaire.domain.Client;

public interface ClientRepository extends CrudRepository<Client, Integer> {

    @Query("SELECT c FROM Client c WHERE c.nom= :nom and c.prenom= :prenom and c.adresse= :adresse and c.cp= :cp and c.adresseMail=:adressemail and c.tel=:tel")
    public Client siClientExiste(@Param("nom") String nom, @Param("prenom") String prenom, @Param("adresse") String adresse, @Param("cp") String cp,
	    @Param("adressemail") String adressemail, @Param("tel") String tel);
}