package com.example.mystock.service.implementation;

import com.example.mystock.Repo.FactureRepository;
import com.example.mystock.entities.Facture;
import com.example.mystock.service.FactureService;
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
public class FactureServiceImplementation implements FactureService {
    private final FactureRepository factureRepository;

    @Override
    public Facture create(Facture facture) {
        log.info("Ajout d'un nouveau Facture : {}",facture.getFact_Achat());
        return factureRepository.save(facture);
    }

    @Override
    public Collection<Facture> list(int limit) {
        log.info("fetching all factures by id");
        return factureRepository.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public Facture get(Long fact_Achat) {
        log.info("Fetching facture by id: {}",fact_Achat);
        return factureRepository.findById(fact_Achat).get();
    }

    @Override
    public Optional<Facture> update(Facture facture, Long fact_Achat) {
        log.info("Updating Facture : {}",fact_Achat);
        return factureRepository.findById(fact_Achat).map(x-> {
            x.setTotalHT(facture.getTotalHT());
            x.setDate(facture.getDate());
            return factureRepository.save(x);
        });
    }

    @Override
    public Boolean delete(Long fact_Achat) {
        log.info("Deleting facture : {}",fact_Achat);
        factureRepository.deleteById(fact_Achat);
        return Boolean.TRUE;
    }
}
