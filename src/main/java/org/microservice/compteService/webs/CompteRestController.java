package org.microservice.compteService.webs;


import org.microservice.compteService.entities.Compte;
import org.microservice.compteService.exceptions.CompteNotFoundException;
import org.microservice.compteService.repositories.ICompteRepository;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class CompteRestController {

    private ICompteRepository compteRepository;

    public CompteRestController(ICompteRepository compteRepository) {
        this.compteRepository = compteRepository;
    }

    @GetMapping("/comptes")
    public List<Compte> listCompte(){
        return compteRepository.findAll();
    }

    @GetMapping("/comptes/{code}")
    public Compte getCompte(@PathVariable Long code) throws CompteNotFoundException {
        return compteRepository.findById(code).orElseThrow(()->new CompteNotFoundException("Compte not Found") );
    }

    @PostMapping("/comptes")
    public Compte saveCompte(@RequestBody Compte compte){
        return compteRepository.save(compte);
    }

    @PutMapping("/comptes/{code}")
    public Compte updateCompte(@PathVariable Long code, @RequestBody Compte compte) throws CompteNotFoundException {
       compte.setCode(code);
       return compteRepository.save(compte);
    }

    @DeleteMapping("/comptes/{code}")
    public void deleteCompte(@PathVariable Long code) throws CompteNotFoundException {
        compteRepository.deleteById(code);
    }
}
