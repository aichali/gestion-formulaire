package com.mab.data.digital.gestion.formulaire.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mab.data.digital.gestion.formulaire.domain.Client;
import com.mab.data.digital.gestion.formulaire.repository.ClientRepository;

@RestController
@RequestMapping("/clients")
public class ClientController {

    protected final ClientRepository clientRepository;

    @Autowired
    public ClientController(ClientRepository clientRepository) {
	this.clientRepository = clientRepository;
    }

    // http:localhost:8082/gestion-formulaire/clients/nom/nom/prenom/prenom/adresse/adresse/cp/cp/mail/mail/tel/tel
    @GetMapping(path = "/nom/{nom}/prenom/{prenom}/adresse/{adresse}/cp/{cp}/mail/{mail}/tel/{tel}")
    public ResponseEntity<Client> search(@PathVariable String nom, @PathVariable String prenom, @PathVariable String adresse, @PathVariable String cp,
	    @PathVariable String mail, @PathVariable String tel) {
	Client client = clientRepository.siClientExiste(nom, prenom, adresse, cp, mail, tel);
	if (client != null) {
	    return ResponseEntity.ok().body(client);
	} else {
	    return ResponseEntity.notFound().build();
	}
    }

    @PostMapping()
    public ResponseEntity<Client> create(@RequestBody Client client) {
	try {
	    Client newClient = clientRepository.save(client);
	    return new ResponseEntity<Client>(newClient, HttpStatus.CREATED);
	} catch (Exception e) {
	    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
    }
}