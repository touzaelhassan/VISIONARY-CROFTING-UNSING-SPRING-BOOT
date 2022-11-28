package com.visionarycrofting.service;

import com.visionarycrofting.entity.AppelOffre;
import com.visionarycrofting.repository.IAppelOffreRepository;
import com.visionarycrofting.service.IService.IAppelOffreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class AppelOffreService implements IAppelOffreService {
    private final IAppelOffreRepository appelOffreRepository;

    @Autowired
    public AppelOffreService(IAppelOffreRepository appelOffreRepository) {
        this.appelOffreRepository = appelOffreRepository;
    }
    public List<AppelOffre> getAppelOffres(){
        return appelOffreRepository.findAll();
    }

    public void addAppelOffre(AppelOffre appelOffre){
        Optional<AppelOffre> appelOffreOptional=appelOffreRepository.findByReference(appelOffre.getReference());
        if(appelOffreOptional.isPresent()){
            throw new IllegalStateException("This reference already exists ");
        }
        appelOffreRepository.save(appelOffre);
    }


}
