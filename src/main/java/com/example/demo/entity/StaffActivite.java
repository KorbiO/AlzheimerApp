package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StaffActivite extends Personne{

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long code_Staff;
	@Column
	private String nom;
	@Column
	private String prenom;
	@Column
	private String sexe;
	@Column
	private String specialite;
	
	@ManyToMany(mappedBy = "staffActivite")
	List<Activite> activite ;
	
	
	
	@ManyToOne
	SalleActivite salleActivite;
	
	@OneToMany(mappedBy="staffActivite" ,cascade=CascadeType.ALL)
	List<Reclamation> reclamation = new ArrayList<>();
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Planning planningg;
	
	//@OneToOne(fetch = FetchType.LAZY, optional = false)
	//@JoinColumn(name = "user_id", nullable = false)
//	private User user ;
	
	
}
