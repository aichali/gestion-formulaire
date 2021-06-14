package com.mab.data.digital.gestion.formulaire.controller;

import java.net.URI;
import java.util.Date;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mab.data.digital.gestion.formulaire.domain.Client;
import com.mab.data.digital.gestion.formulaire.domain.Devis;
import com.mab.data.digital.gestion.formulaire.repository.ClientRepository;
import com.mab.data.digital.gestion.formulaire.repository.DevisRepository;

@RestController
@RequestMapping("/devis")
public class DevisController {

    protected final DevisRepository devisRepository;

    protected final ClientRepository clientRepository;

    @Autowired
    public DevisController(DevisRepository devisRepository, ClientRepository clientRepository) {
	this.devisRepository = devisRepository;
	this.clientRepository = clientRepository;
    }

    @PostMapping()
    @Transactional
    public ResponseEntity<?> create(@RequestBody Devis devis) {
	try {

	    if (StringUtils.isEmpty(devis.getClientId())) {
		return ResponseEntity.badRequest().body("Id client ne doit pas être null");
	    }
	    Optional<Client> client = clientRepository.findById(devis.getClientId());
	    if (client.isPresent()) {
		Client clientObject = client.get();
		devis.setClient(clientObject);
		devis.setClientId(clientObject.getIdClient());
		devis.setDate(new Date());
		devisRepository.save(devis);
		clientObject.getDevis().add(devis);
		return ResponseEntity.created(URI.create("/devis/" + devis.getId())).build();
	    } else {
		return ResponseEntity.notFound().build();
	    }
	} catch (NumberFormatException e) {
	    return ResponseEntity.badRequest().body("Number Format Exception : idClient");
	}
    }
}