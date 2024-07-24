package org.microservice.compteService;

import org.microservice.compteService.entities.Compte;
import org.microservice.compteService.enumerations.TypeCompte;
import org.microservice.compteService.repositories.ICompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class CompteServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompteServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(ICompteRepository compteRepository) {
		return args -> {
			//creation de 3 comptes
			compteRepository.save(new Compte(null, 98000, new Date(), TypeCompte.COURANT));
			compteRepository.save(new Compte(null, 1000, new Date(), TypeCompte.EPARGNE));
			compteRepository.save(new Compte(null, 5000, new Date(), TypeCompte.COURANT));




			compteRepository.findAll().forEach(cp->{
					System.out.println(cp.getType());
					System.out.println(cp.getSolde());
			});
		};
	}
}
