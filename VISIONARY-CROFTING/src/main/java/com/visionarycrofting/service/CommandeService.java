package com.visionarycrofting.service;

import com.visionarycrofting.entity.Commande;
import com.visionarycrofting.repository.ICommandeRepository;
import com.visionarycrofting.service.IService.ICommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommandeService implements ICommandeService {

    @Autowired
    ICommandeRepository commandeRepository;

    @Override
    public Commande save(Commande commande) {
        return commandeRepository.save(commande);
    }

    @Override
    public List<Commande> findAll() {
        return commandeRepository.findAll();
    }

    @Override
    public Optional<Commande> findById(Long id) {
        return commandeRepository.findById(id);
    }

    @Override
    public Commande findByReference(String ref) {
        return commandeRepository.findCommandeByReference(ref);
    }


}
