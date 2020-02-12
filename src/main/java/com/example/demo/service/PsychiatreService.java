package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.entity.Psychiatre;
import com.example.demo.repository.PsychiatreRepository;

@Service
public class PsychiatreService {

	@Autowired
	PsychiatreRepository psychiatreRepository;
	
	public List<Psychiatre> listAll(){
		return psychiatreRepository.findAll();
	}
	
	public void save(Psychiatre psychiatre ) {
		psychiatreRepository.saveAndFlush(psychiatre);
	}
}
