package com.visionarycrofting.controller;

import com.visionarycrofting.entity.Fornisseur;
import com.visionarycrofting.service.IService.IFornisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fornisseur")
public class FornisseurController {

    @Autowired
    IFornisseurService fornisseurService;

    @GetMapping("/")
    public List<Fornisseur> gettAllFornisseur(){
        return fornisseurService.getAllFornisseurs();
    }

    @PostMapping("/")
    public Fornisseur saveFornisseur(@RequestBody Fornisseur fornisseur){
        return fornisseurService.saveFornisseur(fornisseur);
    }
}
