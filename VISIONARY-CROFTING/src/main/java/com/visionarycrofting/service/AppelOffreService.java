package com.visionarycrofting.service;

import com.visionarycrofting.entity.AppelOffre;
import com.visionarycrofting.repository.IAppelOffreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class AppelOffreService {
    private final IAppelOffreRepository appelOffreRepository;

    @Autowired
    public AppelOffreService(IAppelOffreRepository appelOffreRepository) {
        this.appelOffreRepository = appelOffreRepository;
    }
    public List<AppelOffre> getAppelOffres(){
        return appelOffreRepository.findAll();
    }

}
