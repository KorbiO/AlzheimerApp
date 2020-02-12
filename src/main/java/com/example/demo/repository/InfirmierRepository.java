package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Infirmier;

@Repository
public interface InfirmierRepository extends JpaRepository<Infirmier, Long>{

}
