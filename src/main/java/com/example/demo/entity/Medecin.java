package com.example.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Medecin extends Personne {
	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String specialite;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Planning planningggg ;

	public Medecin(String nom, String prenom, String sexe ,int id ,String specialite ,Planning planningggg) {
		super(nom, prenom, sexe);
		this.id=(long) id;
		this.specialite=specialite;
		this.planningggg = planningggg;
		// TODO Auto-generated constructor stub
	}

	
	
}