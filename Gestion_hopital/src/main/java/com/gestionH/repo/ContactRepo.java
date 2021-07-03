package com.gestionH.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestionH.entities.Contact;

public interface ContactRepo extends JpaRepository<Contact, Long> {
	
}
