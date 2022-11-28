package com.visionarycrofting.service.IService;

import com.visionarycrofting.entity.AppelOffre;

import java.util.List;

public interface IAppelOffreService {
    public List<AppelOffre> getAppelOffres();

    public void addAppelOffre(AppelOffre appelOffre);
}
