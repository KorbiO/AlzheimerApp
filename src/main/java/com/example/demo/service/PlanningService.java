package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Planning;
import com.example.demo.repository.PlanningRepository;

@Service
public class PlanningService {

	@Autowired
	PlanningRepository planningRepository;
	
	public List<Planning> listAll(){
		return planningRepository.findAll();
	}
	public void save(Planning planning ) {
		planningRepository.save(planning);
	}
	public Optional<Planning> getById(long id){
		return planningRepository.findById(id);
	}
}
