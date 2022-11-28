package com.visionarycrofting.service;

import com.visionarycrofting.entity.AppelOffre;
import com.visionarycrofting.entity.StatusAppelOffre;
import com.visionarycrofting.repository.IAppelOffreRepository;
import com.visionarycrofting.service.IService.IAppelOffreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    public void deleteAppelOffre(Integer id) {
        boolean exists=appelOffreRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException(
                    "AppelOffre with id "+ id+" doesn't exists"
            );
        }
        appelOffreRepository.deleteById(id);
    }

    @Transactional
    public void updateAppelOffre(Integer id,AppelOffre appelOffreNew){
        Optional<AppelOffre> appelOffre = appelOffreRepository.findById(id);
        if (appelOffre.isPresent()){
            AppelOffre ao=appelOffre.get();
            ao.setReference(appelOffreNew.getReference());
            ao.setStatusAppelOffre(appelOffreNew.getStatusAppelOffre());
            ao.setProduit(appelOffreNew.getProduit());
            ao.setStock(appelOffreNew.getStock());
            ao.setFournisseur(appelOffreNew.getFournisseur());

        }
    }

    @Override
    public List<AppelOffre> findByStatusAppelOffre(StatusAppelOffre statusAppelOffre) {
        return appelOffreRepository.findByStatusAppelOffre(statusAppelOffre);

    }

    public void updateStatus(Integer id,StatusAppelOffre statusAppelOffre){

    }
}
