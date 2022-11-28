package com.visionarycrofting.controller;

import com.sun.istack.NotNull;
import com.visionarycrofting.entity.AppelOffre;
import com.visionarycrofting.entity.Fornisseur;
import com.visionarycrofting.entity.Produit;
import com.visionarycrofting.entity.StatusAppelOffre;
import com.visionarycrofting.service.AppelOffreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("appelOffre")
@Validated
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
    public void updateAppelOffre(@PathVariable("id") Integer id, @RequestBody AppelOffre appelOffre){
     appelOffreService.updateAppelOffre(id,appelOffre);
    }
    @GetMapping(path = "status/{status}")
    public List<AppelOffre> getByStatus(@PathVariable("status") String status ){
        StatusAppelOffre statusAppelOffre=StatusAppelOffre.valueOf(status);
        return appelOffreService.findByStatusAppelOffre(statusAppelOffre);
    }
}
