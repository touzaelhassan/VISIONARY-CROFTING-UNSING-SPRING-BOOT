package com.visionarycrofting.controller;


import com.visionarycrofting.entity.Commande;
import com.visionarycrofting.service.IService.ICommandeService;
import com.visionarycrofting.utils.GenerateReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/commande")
public class CommandeController {

    @Autowired
    ICommandeService commandeService;

    @PostMapping("/add_commande")
    public Commande save(@RequestBody Commande commande) {
        commande.setDate(LocalDate.now());
        commande.setReference(GenerateReference.applyGenerateReference());
        return commandeService.save(commande);
    }

    @GetMapping("/all_commande")
    public List<Commande> findAll(){
        return commandeService.findAll();
    }
    @GetMapping("/commande_id/{id}")
    public Optional<Commande> findById(@PathVariable Long id){
        return commandeService.findById(id);
    }

    @GetMapping("/commande_ref/{ref}")
    public Commande findByReference(@PathVariable String ref){
        return commandeService.findByReference(ref);

    }

}
