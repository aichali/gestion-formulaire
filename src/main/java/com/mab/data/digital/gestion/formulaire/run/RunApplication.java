package com.mab.data.digital.gestion.formulaire.run;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.Transactional;

import com.mab.data.digital.gestion.formulaire.config.DataSourceConfig;
import com.mab.data.digital.gestion.formulaire.controller.ClientController;
import com.mab.data.digital.gestion.formulaire.repository.ClientRepository;
import com.mab.data.digital.gestion.formulaire.repository.DevisRepository;

@SpringBootApplication
@ComponentScan(basePackages = { "com.mab.data.digital.gestion.formulaire" })
@ComponentScan(basePackageClasses = { ClientController.class })
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class, ErrorMvcAutoConfiguration.class, SecurityAutoConfiguration.class })
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