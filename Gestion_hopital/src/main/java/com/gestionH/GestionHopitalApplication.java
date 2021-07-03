package com.gestionH;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gestionH.repo.PatientRepo;
@SpringBootApplication
public class GestionHopitalApplication  {
	
	@Autowired
	PatientRepo pr;
	
	public static void main(String[] args) {
		SpringApplication.run(GestionHopitalApplication.class, args);
	}

}
