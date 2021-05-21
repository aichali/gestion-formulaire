package com.mab.data.digital.gestion.formulaire.run;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.Transactional;

import com.mab.data.digital.gestion.formulaire.config.DataSourceConfig;
import com.mab.data.digital.gestion.formulaire.controller.ClientController;
import com.mab.data.digital.gestion.formulaire.repository.ClientRepository;
import com.mab.data.digital.gestion.formulaire.repository.DevisRepository;

@SpringBootApplication
@ComponentScan(basePackages = { "com.mab.data.digital.gestion.formulaire", "com.mab.data.digital.gestion.formulaire.controller",
	"com.mab.data.digital.gestion.formulaire.repository" })
@ComponentScan(basePackageClasses = { ClientController.class })
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
    }
}