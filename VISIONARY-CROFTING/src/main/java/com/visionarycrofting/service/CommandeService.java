package com.visionarycrofting.service;

import com.visionarycrofting.entity.Commande;
import com.visionarycrofting.repository.ICommandeRepository;
import com.visionarycrofting.service.IService.ICommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommandeService implements ICommandeService {

    @Autowired
    ICommandeRepository commandeRepository;

    @Override
    public Commande save(Commande commande) {
        return commandeRepository.save(commande);
    }
}
