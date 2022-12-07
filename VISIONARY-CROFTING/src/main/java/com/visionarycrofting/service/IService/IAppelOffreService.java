package com.visionarycrofting.service.IService;

import com.visionarycrofting.entity.AppelOffre;
import com.visionarycrofting.entity.StatusAppelOffre;

import java.util.List;
import java.util.Optional;

public interface IAppelOffreService {
    public List<AppelOffre> getAppelOffres();

    public AppelOffre addAppelOffre(AppelOffre appelOffre);

    public void deleteAppelOffre(Integer id);

    public AppelOffre updateAppelOffre(Integer id, AppelOffre appelOffre);

    public List<AppelOffre> findByStatusAppelOffre(StatusAppelOffre statusAppelOffre);

    Optional<AppelOffre> findById(Integer id);

}
