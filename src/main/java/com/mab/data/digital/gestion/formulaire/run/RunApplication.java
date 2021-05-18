package com.mab.data.digital.gestion.formulaire.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import com.mab.data.digital.gestion.formulaire.config.DataSourceConfig;

@SpringBootApplication
@ComponentScan(basePackages = "com.mab.data.digital.gestion.formulaire")
@Import({ DataSourceConfig.class })
public class RunApplication {

    public static void main(String[] args) {
	SpringApplication.run(RunApplication.class, args);
	System.out.print("*** Projet de Gestion de Formulaire ***");
    }
}