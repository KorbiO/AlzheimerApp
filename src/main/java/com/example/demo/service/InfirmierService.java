package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Infirmier;
import com.example.demo.repository.InfirmierRepository;

@Service
public class InfirmierService {

	@Autowired
	InfirmierRepository infirmierRepository;
	
	public List<Infirmier> listAll(){
		return infirmierRepository.findAll();
	}
	
	public void save(Infirmier infirmer ) {
		infirmierRepository.saveAndFlush(infirmer);
	}
	
	public Integer count() {
		return (int) infirmierRepository.count();
	}
	
}
