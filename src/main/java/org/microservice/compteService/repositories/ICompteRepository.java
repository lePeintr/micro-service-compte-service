package org.microservice.compteService.repositories;

import org.microservice.compteService.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICompteRepository extends JpaRepository<Compte,Long> {
}
