package com.gestionH.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.gestionH.entities.Patient;
import com.gestionH.repo.PatientRepo;

@Controller
@RequestMapping("/patient")
public class PatientController {
	@Autowired
	PatientRepo pr;
	@Autowired


	@GetMapping("/home")
	public String home() {
		return "rendezvous/accueil";
	}
	
	@GetMapping({"/","/accueil"})
	public  String accueil(Model model) {
		model.addAttribute("titre","La liste des patients");
		model.addAttribute("info","informations du patient");
		List<Patient> patients=pr.findAll();
		Patient patient=new Patient();
		model.addAttribute("patients",patients);
		model.addAttribute("patient",patient);
		
		
		return "rendezvous/index";

	}
	@PostMapping("/save")	
	public String save(Patient patient,Model model ) {
		
		pr.save(patient);
		return "redirect:/patient/home";
	}
	@PostMapping("/save2")	
	public String save2(Patient patient,Model model ) {
		
		pr.save(patient);
		return "rendezvous/accueil";
	}


	
	@GetMapping("/delete/{id}")	
	public String supprimer(@PathVariable("id") long  id  ) {
		
		pr.deleteById(id);
		return "redirect:/patient/accueil";
	}
	@GetMapping("/recherche")
public String rechercher(@PathVariable("id") long  id , Model model ) {
		
		Patient patient = pr.findById(id).orElseThrow(() -> new IllegalArgumentException("L'id:" + id + " n'est attribué à aucun(e) patient(e)"));
		model.addAttribute("patients", patient);
		return "rendezvous/info";
	}
	
	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Patient patient = pr.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("L'id:" + id + " n'est attribué à aucun(e) patient(e)"));
		model.addAttribute("patients", patient);
		model.addAttribute("patients", patient);
		model.addAttribute("info", "Modification des informations du patient "+ patient.getPrenom()+ " "+ patient.getNom());

		return "rendezvous/update-patient";
	}

}
