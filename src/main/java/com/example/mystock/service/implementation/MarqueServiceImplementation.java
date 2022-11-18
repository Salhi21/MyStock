package com.example.mystock.service.implementation;

import com.example.mystock.Repo.MarqueRepository;
import com.example.mystock.entities.Marque;
import com.example.mystock.service.MarqueService;
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
public class MarqueServiceImplementation implements MarqueService {
    private final MarqueRepository marqueRepository;

    @Override
    public Marque create(Marque marque) {
        log.info("Ajout d'un nouveau marque : {}", marque.getIdMarque());
        return marqueRepository.save(marque);
    }

    @Override
    public Collection<Marque> list(int limit) {
         log.info("fetching all marques by id");
        return marqueRepository.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public Marque get(Long idMarque) {
        log.info("Fetching Marque by id: {}",idMarque);
        return  marqueRepository.findById(idMarque).get();
    }

    @Override
    public Optional<Marque> update(Marque marque, Long idMarque) {
        log.info("Updating Marque : {}",idMarque);
        return marqueRepository.findById(idMarque).map(x-> {
            x.setIdMarque(marque.getIdMarque());
            x.setLibMarque(marque.getLibMarque());
            return marqueRepository.save(x);
        });
    }

    @Override
    public Boolean delete(Long idMarque) {
        log.info("Deleting Marque : {}",idMarque);
        marqueRepository.deleteById(idMarque);
        return Boolean.TRUE;
    }
}
