package com.visionarycrofting.service.IService;

import com.visionarycrofting.entity.Commande;
import com.visionarycrofting.entity.CommandeItems;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ICommandeService {
    Commande save(Commande commande);
    List<Commande> findAll();
    Optional<Commande> findById(Long id);
    Commande findByReference(String ref);


    List<Commande> findEffectuedCommands();
}
