package com.example.demo.controller;

import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Activite;
import com.example.demo.entity.Infirmier;
import com.example.demo.entity.Patient;
import com.example.demo.entity.Planning;
import com.example.demo.repository.InfirmierRepository;
import com.example.demo.repository.PatientRepository;
import com.example.demo.service.InfirmierService;
import com.example.demo.service.PatientService;
import com.example.demo.service.PlanningService;

@Controller
@RequestMapping("/infirmier")
public class Infirmercontroller {

	@Autowired
	InfirmierRepository infirmierRepository;
	
	@Autowired
	InfirmierService infirmierService;
	
	@Autowired
	PatientRepository patientRepository;
	
	@Autowired
	PlanningService planningService;
	
	@Autowired
	PatientService patientService;
	
	@GetMapping("/controlleretat")
	public String listetat(Model model) {
		List<Patient> listPatient = patientRepository.findAll();
		model.addAttribute("listPatient", listPatient);
		return "list-etat";
	}
	
	
	@GetMapping("/listplanning")
	public String listPlanning(Model model) {
		List<Infirmier> listPlanning = infirmierService.listAll();
		model.addAttribute("listPlanning", listPlanning);
		return "infirmier";
	}
	
	@GetMapping("/editpatient/{id}")
	public String showUpdateForm3(@PathVariable("id") Long id, Model model) {
	   Patient patient = patientService.getById(id)
	  . orElseThrow(()-> new NoSuchElementException("Invalid patient:" + id));		//orElseThrow(() -> new IllegalArgumentException("Invalid user Login:" + login))

	    model.addAttribute("patient", patient);
	    return "update-patient-etat";
	}
	
	@PostMapping("/updatepatient/{id}")
	public String updatepatientetat(@PathVariable("id") Long id, @Valid Patient patient,
	  BindingResult result, Model model) {
	    if (result.hasErrors()) {
	        patient.setId(id);
	        return "redirect:/infirmier/controlleretat";
	    }
	    	
	 
		patientRepository.save(patient);

	    model.addAttribute("patients", patientService.listAll());
	    return "redirect:/infirmier/controlleretat";
	}
	
	
	@GetMapping("/deletepatient/{id}")
	public String deletepatientetat(@PathVariable("id") Long id, Model model) {
	    Patient patient = patientService.getById(id)
	    		 .orElseThrow(()-> new NoSuchElementException("Invalid patient" + id));
	
	    patientRepository.delete(patient);
	 
	    model.addAttribute("patients", patientService.listAll());
	    return "redirect:/infirmier/controlleretat";
	}		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
