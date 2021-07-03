package com.gestionH.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gestionH.entities.Contact;
import com.gestionH.repo.ContactRepo;

@Controller
@RequestMapping("/contact")
public class ContactController {
	@Autowired
	ContactRepo cr;
	
	@GetMapping("/home")
	public String home() {
		return "rendezvous/accueil";
	}
	@PostMapping("/save")	
	public String save(Contact contact ) {
		cr.save(contact);
		return "redirect:/contact/home";
	}
	@GetMapping("/message")
	public String message(Model model) {
		model.addAttribute("titre","Les messages des visiteurs");
		model.addAttribute("info","informations du patient");
		List<Contact> contacts=cr.findAll();
		Contact contact=new Contact();
		model.addAttribute("contacts",contacts);
		model.addAttribute("contact",contact);

		return "/rendezvous/contact";
	}
	@GetMapping("/delete/{id}")	
	public String supprimer(@PathVariable("id") long  id  ) {
		
		cr.deleteById(id);
		return "redirect:/contact/message";
	}


}
