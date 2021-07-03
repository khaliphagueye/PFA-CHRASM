package com.gestionH.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY) 
private long id;
private String nom;
private String prenom;
private String email;
private String maladie;
private String groupeSanguin;
private String adresse;
private String telephone;
private Date date;
private String department; 




public Patient(long id, String nom, String prenom, String email, String maladie, String groupeSanguin, String adresse,
		String telephone) {
	super();
	this.id = id;
	this.nom = nom;
	this.prenom = prenom;
	this.email = email;
	this.maladie = maladie;
	this.groupeSanguin = groupeSanguin;
	this.adresse = adresse;
	this.telephone = telephone;
}


}
