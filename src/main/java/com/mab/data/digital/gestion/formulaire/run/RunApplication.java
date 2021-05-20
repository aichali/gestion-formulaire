package com.mab.data.digital.gestion.formulaire.run;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.Transactional;

import com.mab.data.digital.gestion.formulaire.config.DataSourceConfig;
import com.mab.data.digital.gestion.formulaire.domain.Client;
import com.mab.data.digital.gestion.formulaire.domain.Devis;
import com.mab.data.digital.gestion.formulaire.repository.ClientRepository;
import com.mab.data.digital.gestion.formulaire.repository.DevisRepository;

@SpringBootApplication
@ComponentScan(basePackages = "com.mab.data.digital.gestion.formulaire")
@Import({ DataSourceConfig.class })
public class RunApplication implements CommandLineRunner {

    @Resource
    private ClientRepository clientRepository;

    @Resource
    private DevisRepository devisRepository;

    public static void main(String[] args) {
	SpringApplication.run(RunApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... strings) throws Exception {
	System.out.println("*** Projet de Gestion de Formulaire ***");

	Client client = new Client("nom", "prenom", "adresse", "cp", "mail", "tel");
	clientRepository.save(client);
	System.out.println("Liste des clients  :  " + clientRepository.findAll());

	Devis devis = new Devis(new Date(), "expertises", "message");
	devis.setClient(client);
	devis.setClientId(client.getIdClient());
	devisRepository.save(devis);
	System.out.println("Liste des devis  :  " + devisRepository.findAll());

	Client searchClient = clientRepository.siClientExiste("nom", "prenom", "adresse", "cp", "mail", "tel");
	System.out.println("Client trouvé  :  " + searchClient);
	System.out.println("Nombre Devis  :  " + searchClient.getDevis().size());

	searchClient.getDevis().add(devis);
	searchClient = clientRepository.save(searchClient);

	searchClient = clientRepository.siClientExiste("nom", "prenom", "adresse", "cp", "mail", "tel");
	System.out.println("Client trouvé  :  " + searchClient);
	System.out.println("Nombre Devis  :  " + searchClient.getDevis().size());
    }
}