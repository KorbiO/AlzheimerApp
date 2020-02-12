package com.example.demo.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.Patient;
import com.example.demo.service.InfirmierService;
import com.example.demo.service.MedecinService;
import com.example.demo.service.PatientService;
import com.example.demo.service.StaffActiviteService;

@Controller
public class GraphController {

	@Autowired
	PatientService patientService;
	
	@Autowired
	StaffActiviteService staffActiviteService;
	
	@Autowired
	InfirmierService infirmierService;
	
	@Autowired
	MedecinService medecinService;
	
	@GetMapping("/displayBarGraph")
	public String barGraph(Model model) {
		Map<String, Integer> surveyMap = new LinkedHashMap<>();
		Integer patient = patientService.count();
		Integer staffActivite = staffActiviteService.count();
		Integer infirmier = infirmierService.count();
		Integer medecin = medecinService.count();
		surveyMap.put("Patient", patient);
		surveyMap.put("Staff Activité", staffActivite);
		surveyMap.put("infirmier", infirmier);
		surveyMap.put("medecin", medecin);
		
		model.addAttribute("surveyMap", surveyMap);
		return "home";
	}
}
