package com.visionarycrofting.repository;

import com.visionarycrofting.entity.AppelOffre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAppelOffreRepository extends JpaRepository<AppelOffre,Integer> {
}
