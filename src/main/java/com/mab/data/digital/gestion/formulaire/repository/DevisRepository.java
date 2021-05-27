package com.mab.data.digital.gestion.formulaire.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mab.data.digital.gestion.formulaire.domain.Devis;

@Repository
public interface DevisRepository extends CrudRepository<Devis, Integer> {

}