package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.demo.repository.PsychiatreRepository;
import com.example.demo.service.PsychiatreService;

@Controller
public class PsychiatreController {
	
	@Autowired
	PsychiatreRepository psychiatreRepository;
	
	@Autowired
	PsychiatreService psychiatreService;
	
	

}
