package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.example.demo.entity.DossierMedical;
import com.example.demo.entity.Medecin;
import com.example.demo.entity.Planning;
import com.example.demo.entity.SalleActivite;
import com.example.demo.entity.VisAVis;
import com.example.demo.repository.DossierMedicalRepository;
import com.example.demo.repository.MedecinRepository;
import com.example.demo.repository.PlanningRepository;
import com.example.demo.repository.SalleActiviteRepository;
import com.example.demo.repository.VisAVisRepository;



@SpringBootApplication
@ComponentScan
public class AlzheimerrApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlzheimerrApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(DossierMedicalRepository dossierMedical , VisAVisRepository visAVis , PlanningRepository planning , SalleActiviteRepository salleActivite 
			, MedecinRepository medecin) {
		
			
		return args -> {
			dossierMedical.save(new DossierMedical(4,"Passable","Passable","Passable","Passable","Passable"));
			dossierMedical.save(new DossierMedical(3,"Passable","mauvais","mauvais","Passable","Passable"));
			visAVis.save(new VisAVis("père", "mécanicien", 45, "cele"));
	
			salleActivite.save(new SalleActivite("1", 15, 1));
			salleActivite.save(new SalleActivite("2", 20, 1));
		//	medecin.save(new Medecin("omar","korbi","homme",1,"chorgo",new Planning("01/02/2019", "01/02/2019", "patient X")));
		};
	} 
}

