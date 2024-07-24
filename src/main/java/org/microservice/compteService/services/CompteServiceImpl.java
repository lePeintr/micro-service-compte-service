package org.microservice.compteService.services;

import org.microservice.compteService.entities.Compte;
import org.microservice.compteService.repositories.ICompteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CompteServiceImpl implements ICompteService{
    private ICompteRepository compteRepository;

    public CompteServiceImpl(ICompteRepository compteRepository) {
        this.compteRepository = compteRepository;
    }

    @Override
    public void virement(Long codeSource, Long codeDestination, double montant) {
        Compte c1 = compteRepository.getById(codeSource) ;
        Compte c2 = compteRepository.getById(codeDestination);
        c1.setSolde(c1.getSolde()-montant);
        c2.setSolde(c2.getSolde()+montant);

    }
}
