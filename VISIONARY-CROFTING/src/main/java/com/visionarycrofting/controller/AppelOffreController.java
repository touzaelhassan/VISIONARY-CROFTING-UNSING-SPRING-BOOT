package com.visionarycrofting.controller;

import com.visionarycrofting.entity.AppelOffre;
import com.visionarycrofting.entity.Fornisseur;
import com.visionarycrofting.entity.Produit;
import com.visionarycrofting.entity.StatusAppelOffre;
import com.visionarycrofting.service.AppelOffreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("appelOffre")
public class AppelOffreController {
    private final AppelOffreService appelOffreService;

    @Autowired
    public AppelOffreController(AppelOffreService appelOffreService) {
        this.appelOffreService = appelOffreService;
    }

    @GetMapping
    public List<AppelOffre> getAppelOffres(){
        return appelOffreService.getAppelOffres();
    }
    @PostMapping
    public void addAppelOffre(@RequestBody AppelOffre appelOffre){
        appelOffreService.addAppelOffre(appelOffre);
    }
    @DeleteMapping(path = "{id}")
    public void deleteAppelOffre(@PathVariable("id") Integer id){
        appelOffreService.deleteAppelOffre(id);

    }
    @PutMapping(path = "{id}")
    public void updateAppelOffre(@PathVariable("id") Integer id, @RequestParam(required = false)String reference, @RequestParam(required = false) StatusAppelOffre statusAppelOffre, @RequestParam(required = false) Produit produit,@RequestParam(required = false) Fornisseur fournisseur){
     appelOffreService.updateAppelOffre(id,reference,statusAppelOffre,produit,fournisseur);
    }




}
