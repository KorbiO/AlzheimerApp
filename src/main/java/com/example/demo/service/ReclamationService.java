package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Reclamation;
import com.example.demo.repository.ReclamationRepository;

@Service
public class ReclamationService {

	@Autowired
	ReclamationRepository reclamationRepository;
	
	public List<Reclamation> listAll(){
		return reclamationRepository.findAll();
	}
	public void save(Reclamation reclamation ) {
		reclamationRepository.save(reclamation);
	}
	public Optional<Reclamation> getById(long id){
		return reclamationRepository.findById(id);
	}
}
