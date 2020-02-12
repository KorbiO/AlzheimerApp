package com.example.demo.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
public class User extends Personne{
	@Id
	@Column(unique = true)
	private String login;
	@Column
	private String password;
	@Column
	private String nature;
	//@Id
  //  @GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long id ;
	
	public User(String login , String password , String nature,String nom, String prenom , String sexe) {
		super(nom,prenom,sexe);
		this.login=login;
		this.password=password;
		this.nature=nature;
	}
	

	
	
//	@OneToOne(mappedBy = "user", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
 //   private StaffActivite staffActivite;
	
	@OneToMany(mappedBy = "user")
	List<Planning> planning = new ArrayList<>();

	
}
