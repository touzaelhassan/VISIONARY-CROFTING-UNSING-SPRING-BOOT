package com.visionarycrofting.repository;

import com.visionarycrofting.entity.AppelOffre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IAppelOffreRepository extends JpaRepository<AppelOffre,Integer> {
    Optional<AppelOffre> findByReference(String reference);
}
