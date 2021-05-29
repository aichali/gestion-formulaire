package com.mab.data.digital.gestion.formulaire.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mab.data.digital.gestion.formulaire.domain.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Integer> {

    @Query(value = "SELECT * FROM Client c WHERE c.nom= :nom and c.prenom= :prenom and c.adresse= :adresse and c.cp= :cp and c.mail =:mail and c.tel=:tel", nativeQuery = true)
    public Client siClientExiste(@Param("nom") String nom, @Param("prenom") String prenom, @Param("adresse") String adresse, @Param("cp") String cp,
	    @Param("mail") String mail, @Param("tel") String tel);
}