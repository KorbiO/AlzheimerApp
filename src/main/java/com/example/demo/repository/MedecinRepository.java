package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Medecin;

@Repository
public interface MedecinRepository extends JpaRepository<Medecin, Long>{
	
	Optional<Medecin> findById(Long id);

}
