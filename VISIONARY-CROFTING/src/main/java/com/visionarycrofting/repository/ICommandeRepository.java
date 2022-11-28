package com.visionarycrofting.repository;

import com.visionarycrofting.entity.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommandeRepository extends JpaRepository<Commande,Long> {
}
