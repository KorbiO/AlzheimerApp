package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.entity.Medecin;
import com.example.demo.repository.MedecinRepository;

@Service
public class MedecinService {

	@Autowired
	MedecinRepository medecinRepository;
	
	public List<Medecin> listAll(){
		return medecinRepository.findAll();
	}
	
	public void save(Medecin medecin ) {
		medecinRepository.saveAndFlush(medecin);
	}
	public Integer count() {
		return (int) medecinRepository.count();
	}
}
