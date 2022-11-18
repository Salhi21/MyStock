package com.example.mystock.service.implementation;

import com.example.mystock.Repo.UtilisateurRepository;
import com.example.mystock.entities.Utilisateur;
import com.example.mystock.service.UtilisateurService;
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
public class UtilisateurServiceImplementation implements UtilisateurService {
    private final UtilisateurRepository utilisateurRepository;

    @Override
    public Utilisateur create(Utilisateur utilisateur) {
        log.info("Ajout d'un nouveau Utilisateur : {}",utilisateur.getIdutil());
        return utilisateurRepository.save(utilisateur);
    }

    @Override
    public Collection<Utilisateur> list(int limit) {
        log.info("fetching all users by id");
        return utilisateurRepository.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public Utilisateur get(Long idutil) {
        log.info("Fetching produit by id: {}",idutil);
        return utilisateurRepository.findById(idutil).get();
    }

    @Override
    public Optional<Utilisateur> update(Utilisateur utilisateur, Long idutil) {
        log.info("Updating Utilisateur : {}",idutil);
        return utilisateurRepository.findById(idutil).map(x-> {
            x.setNom(utilisateur.getNom());
            x.setPrenom(utilisateur.getPrenom());
            x.setEmail(utilisateur.getEmail());
            return utilisateurRepository.save(x);
        });
    }


    @Override
    public Boolean delete(Long idutil) {
        log.info("Deleting user : {}",idutil);
        utilisateurRepository.deleteById(idutil);
        return Boolean.TRUE;
    }
}
