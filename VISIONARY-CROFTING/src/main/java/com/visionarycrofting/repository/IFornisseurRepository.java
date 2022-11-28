package com.visionarycrofting.repository;

import com.visionarycrofting.entity.Fornisseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFornisseurRepository extends JpaRepository<Fornisseur,Integer> {
    public Fornisseur findByEmail(String email);
}
