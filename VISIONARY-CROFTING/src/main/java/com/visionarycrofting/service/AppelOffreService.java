package com.visionarycrofting.service;

import com.visionarycrofting.repository.IAppelOffreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppelOffreService {
    private final IAppelOffreRepository appelOffreRepository;

    @Autowired
    public AppelOffreService(IAppelOffreRepository appelOffreRepository) {
        this.appelOffreRepository = appelOffreRepository;
    }


}
