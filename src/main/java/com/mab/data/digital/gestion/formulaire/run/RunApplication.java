package com.mab.data.digital.gestion.formulaire.run;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import com.mab.data.digital.gestion.formulaire.config.DataSourceConfig;
import com.mab.data.digital.gestion.formulaire.repository.ClientRepository;

@SpringBootApplication
@ComponentScan(basePackages = "com.mab.data.digital.gestion.formulaire")
@Import({ DataSourceConfig.class })
public class RunApplication implements CommandLineRunner {

    @Resource
    ClientRepository clientRepository;

    public static void main(String[] args) {
	SpringApplication.run(RunApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
	System.out.print("*** Projet de Gestion de Formulaire ***");

	Client client = clientRepository.siClientExiste(nom, prenom, adresse, cp, adressemail, tel);

    }

}