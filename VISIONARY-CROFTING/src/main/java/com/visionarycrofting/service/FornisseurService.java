package com.visionarycrofting.service;

import com.visionarycrofting.entity.Fornisseur;
import com.visionarycrofting.repository.IFornisseurRepository;
import com.visionarycrofting.service.IService.IFornisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornisseurService implements IFornisseurService {

    @Autowired
    IFornisseurRepository fornisseurRepository;

    @Override
    public Fornisseur saveFornisseur(Fornisseur fornisseur) {
        fornisseurRepository.save(fornisseur);
        return fornisseur;
    }

    @Override
    public Fornisseur findByEmail(String email) {
        return fornisseurRepository.findByEmail(email);
    }

    @Override
    public List<Fornisseur> getAllFornisseurs() {
        return fornisseurRepository.findAll();
    }
}
