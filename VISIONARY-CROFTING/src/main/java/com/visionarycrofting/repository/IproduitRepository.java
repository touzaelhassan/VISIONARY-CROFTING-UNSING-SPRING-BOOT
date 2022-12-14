package com.visionarycrofting.repository;

import com.visionarycrofting.entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IproduitRepository extends JpaRepository<Produit, Long> {

    List<Produit> findByCategory(int category);

}
