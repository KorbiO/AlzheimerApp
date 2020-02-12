package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DossierMedical {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long num;
	@Column
	private int stade;
	@Column
	private String niveaucardiologie ;
	@Column
	private String niveaunephrologie;	//kila
	@Column
	private String niveauneurologie;	//a3sab
	@Column
	private String niveauneonatalogie;	//communication
	@Column
	private String niveauhematologie;	//dam
	
	public DossierMedical(int stade , String niveaucardiologie ,String niveaunephrologie , String niveauneurologie , String niveauneonatalogie , String niveauhematologie ) {
		this.stade = stade ;
		this.niveaucardiologie=niveaucardiologie;
		this.niveauhematologie=niveauhematologie;
		this.niveaunephrologie=niveaunephrologie;
		this.niveauneonatalogie=niveauneonatalogie;
		this.niveauneurologie=niveauneurologie;
	}
	@OneToOne(mappedBy = "dossierMedical")
	private Patient patient ;
	
	
//	@OneToOne(fetch =FetchType.LAZY,optional = false)
	//@JoinColumn(name="code_P")
	//private Patient patient;
	
}
