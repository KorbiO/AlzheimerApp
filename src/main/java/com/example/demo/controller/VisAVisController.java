package com.example.demo.controller;

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

import com.example.demo.entity.Patient;
import com.example.demo.entity.Reservation;
import com.example.demo.repository.PatientRepository;
import com.example.demo.repository.ReservationRepository;

@Controller
@RequestMapping("/visavis")
public class VisAVisController {

	@Autowired
	PatientRepository patientRepository;
	
	
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@GetMapping("/controlleretat/{id}")
	public String listetat(Model model,@PathVariable("id") Long id ){
		Patient patient = patientRepository.findById(id)
				. orElseThrow(()-> new NoSuchElementException("Invalid Patient:" + id));	

		model.addAttribute("patient", patient);
		return "list-etat-from-visavis";
	}
	@GetMapping("/listreservationvisavis/{id}")
	public String list_Reservation(Model model, @PathVariable("id") Long id) {
		Reservation listReservation= reservationRepository.findById(id)
				. orElseThrow(()-> new NoSuchElementException("Invalid Reservation:" + id));	;
		model.addAttribute("listReservation", listReservation);
		return "list-reservation-visavis";
	}

	
	 @GetMapping("/goaddre")
	public String showUpdateForm(Reservation reservation) {
		return "add-reservation-visavis";
	}
	@PostMapping("/addreservationvisavis")
    public String addReservation(@Valid Reservation reservation, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-reservation-visavis";
        }
        reservationRepository.save(reservation);
        Long id= reservation.getId();
        
        return "redirect:/visavis/listreservationvisavis/"+id;
	
}	
	
}
