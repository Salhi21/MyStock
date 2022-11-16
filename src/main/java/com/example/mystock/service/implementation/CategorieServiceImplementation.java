package com.example.mystock.service.implementation;

import com.example.mystock.Repo.CategorieRepository;
import com.example.mystock.entities.Categorie;
import com.example.mystock.service.CategorieService;
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
public class CategorieServiceImplementation implements CategorieService {
    private final CategorieRepository categorieRepo;

    @Override
    public Categorie create(Categorie categorie) {
        log.info("Ajout d'un nouveau categorie : {}", categorie.getIdCateg());
        return categorieRepo.save(categorie);
    }

    @Override
    public Collection<Categorie> list(int limit) {
        log.info("fetching all categories by id");
        return categorieRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
        public Categorie get(Long idCateg) {
        log.info("Fetching Categorie by id: {}",idCateg);
        return  categorieRepo.findById(idCateg).get();
    }


    @Override
    public Optional<Categorie> update(Categorie categorie, Long id) {
        log.info("Updating Categorie : {}",id);
        return categorieRepo.findById(id).map(x-> {
            x.setIdCateg(categorie.getIdCateg());
            x.setLibCateg(categorie.getLibCateg());
            return categorieRepo.save(x);
        });
    }

    @Override
    public Boolean delete(Long idCateg) {
        log.info("Deleting categorie : {}",idCateg);
        categorieRepo.deleteById(idCateg);
        return Boolean.TRUE;
    }
}
