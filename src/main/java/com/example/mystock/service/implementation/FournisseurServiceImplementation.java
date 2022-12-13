package com.example.mystock.service.implementation;

import com.example.mystock.Repo.FournisseurRepository;
import com.example.mystock.Repo.ProduitRepository;
import com.example.mystock.entities.Categorie;
import com.example.mystock.entities.Fournisseur;
import com.example.mystock.entities.Produit;
import com.example.mystock.service.FournisseurService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class FournisseurServiceImplementation implements FournisseurService {
    private final FournisseurRepository fournisseurRepo ;

    @Override
    public Fournisseur create(Fournisseur fournisseur) {
        log.info("Ajout d'un nouveau Fournisseur : {}", fournisseur.getIdFournisseur());
        return fournisseurRepo.save(fournisseur);
    }

    @Override
    public Collection<Fournisseur> list(int limit) {
        log.info("fetching all fournisseurs by id");
        return fournisseurRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public Fournisseur get(Long idFournisseur) {
        log.info("Fetching Fournisseur by id: {}",idFournisseur);
        return  fournisseurRepo.findById(idFournisseur).get();
    }

    @Override
    public Optional<Fournisseur> update(Fournisseur fournisseur, Long idFournisseur) {
        log.info("Updating Fournisseur : {}",idFournisseur);
        return fournisseurRepo.findById(idFournisseur).map(x-> {
            x.setEmailFournisseur(fournisseur.getEmailFournisseur());
            x.setAdresseFournisseur(fournisseur.getAdresseFournisseur());
            x.setNomFournisseur(fournisseur.getNomFournisseur());
            x.setTelFournisseur(fournisseur.getTelFournisseur());
            return fournisseurRepo.save(x);
        });
    }

    @Override
    public Boolean delete(Long idFournisseur) {
        log.info("Deleting fournisseur : {}",idFournisseur);
        fournisseurRepo.deleteById(idFournisseur);
        return Boolean.TRUE;
    }
}
