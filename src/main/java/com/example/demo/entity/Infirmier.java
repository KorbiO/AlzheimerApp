package com.example.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Infirmier extends Personne {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long code;
	@Column
	private String nom;
	@Column
	private String prenom;
	@Column
	private String sexe;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Planning planninggg;
}
