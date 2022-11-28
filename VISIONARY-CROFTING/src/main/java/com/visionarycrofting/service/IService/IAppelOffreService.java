package com.visionarycrofting.service.IService;

import com.visionarycrofting.entity.AppelOffre;
import com.visionarycrofting.entity.Produit;
import com.visionarycrofting.entity.StatusAppelOffre;

import java.util.List;

public interface IAppelOffreService {
    public List<AppelOffre> getAppelOffres();

    public void addAppelOffre(AppelOffre appelOffre);

    public void deleteAppelOffre(Integer id);

    public void updateAppelOffre(Integer id, String reference, StatusAppelOffre statusAppelOffre, Produit produit);
}
