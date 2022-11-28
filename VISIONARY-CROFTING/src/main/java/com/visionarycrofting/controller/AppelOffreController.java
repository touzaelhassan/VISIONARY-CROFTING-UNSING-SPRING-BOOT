package com.visionarycrofting.controller;

import com.visionarycrofting.entity.AppelOffre;
import com.visionarycrofting.service.AppelOffreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("appelOffre/")
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



}
