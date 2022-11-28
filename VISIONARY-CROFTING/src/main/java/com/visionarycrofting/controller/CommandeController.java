package com.visionarycrofting.controller;


import com.visionarycrofting.entity.Client;
import com.visionarycrofting.entity.Commande;
import com.visionarycrofting.service.IService.ICommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/commande")
public class CommandeController {

    @Autowired
    ICommandeService commandeService;

    @PostMapping("/add_commande")
    public Commande save(@RequestBody Commande commande) {
        return commandeService.save(commande);
    }



}
