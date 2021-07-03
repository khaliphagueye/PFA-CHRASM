package com.gestionH.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestionH.entities.Patient;

public interface PatientRepo extends JpaRepository<Patient, Long> {

	void deleteById(int id);

}
