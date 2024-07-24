package org.microservice.compteService.services;

public interface ICompteService {
    void virement(Long codeSource,Long codeDestination,double montant);
}
