package com.example.mystock.service.implementation;

import com.example.mystock.Repo.ProduitRepository;
import com.example.mystock.entities.Produit;
import com.example.mystock.service.ProduitService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class ProduitServiceImplementation implements ProduitService {
    private final ProduitRepository prouitRepo ;

    @Override
    public Produit create(Produit produit) {
        log.info("Ajout d'un nouveau produit : {}",produit.getIdProduit());
        return prouitRepo.save(produit);
    }

    @Override
    public Produit get(Long idProduit) {
        log.info("Fetching produit by id: {}",idProduit);
        return prouitRepo.findById(idProduit).get();
    }

    @Override
    public Produit update(Produit produit) {
        log.info("Updating Produit : {}",produit.getIdProduit());
        return prouitRepo.save(produit);
    }

    @Override
    public String delete(Long idProduit) {
        log.info("Deleting produit : {}",idProduit);
        prouitRepo.deleteById(idProduit);
        System.out.println("deleting");
        return "ok" ;
    }

    @Override
    public Collection<Produit> list(int limit) {
        log.info("fetching all products by id");
        return prouitRepo.findAll(PageRequest.of(0,limit)).toList();
    }
    @Override
    public Produit update(Long idProduit, Produit produit) {
        log.info("Updating Produit : {}",produit.getIdProduit());
        return prouitRepo.findById(idProduit).map(x->{
            x.setPrix(produit.getPrix());
            x.setCategorie(produit.getCategorie());
            x.setDateAjout(produit.getDateAjout());
            x.setLibProd(produit.getLibProd());
            x.setPrixLivr(produit.getPrixLivr());
            x.setDescProd(produit.getDescProd());
            x.setMarque(produit.getMarque());
            return prouitRepo.save(x);
        }).orElseGet(()->{
            produit.setIdProduit(idProduit);
            return prouitRepo.save(produit);
        });
           }
}
