package com.example.demo.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Planning {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id ;
	
	@Column
	private String datedeb;
	
	@Column
	private String datefin;
	
	@Column
	private String mission ;
	
	public Planning(String datedeb , String datafin , String mission) {
		this.datedeb= datedeb;
		this.datefin= datafin;
		this.mission = mission;
	}
	
	
	
	@OneToMany(mappedBy="planningg")
	List<StaffActivite> staffActivite= new ArrayList<>();
	
	@OneToMany(mappedBy = "planninggg")
	List<Infirmier> infirmier = new ArrayList<>();
	
	@OneToMany(mappedBy = "planningggg")
	List<Medecin> medecin = new ArrayList<Medecin>();
	@ManyToOne( cascade = CascadeType.ALL)
	private User user ;
}
