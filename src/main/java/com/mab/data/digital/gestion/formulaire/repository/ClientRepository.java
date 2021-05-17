package com.mab.data.digital.gestion.formulaire.repository;

import org.springframework.data.repository.CrudRepository;

import com.mab.data.digital.gestion.formulaire.domain.Client;

public interface ClientRepository extends CrudRepository<Client, Integer> {

}