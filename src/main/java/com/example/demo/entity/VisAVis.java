package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VisAVis extends Personne{

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String relation;
	@Column
	private String proffesion;
	@Column
	private int age;
	@Column
	private String etatCivil;
	
	public VisAVis(String relation , String proffesion , int age , String etatCivil) {
		this.relation=relation;
		this.proffesion=proffesion;
		this.age=age;
		this.etatCivil=etatCivil;
	}
	
	@OneToMany(mappedBy = "visAvis")
	List<Patient> patients = new ArrayList<Patient>();
	
	@OneToMany(mappedBy ="visAvis")
	List<Reservation> reservation = new ArrayList<Reservation>();
}
