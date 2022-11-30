package com.visionarycrofting.service.IService;

import com.visionarycrofting.entity.CommandeItems;
import com.visionarycrofting.entity.Produit;

import java.util.List;

public interface IProduitService {

    Produit addProduit(Produit produit);
    Produit updateProduit(Produit produit, Long productId);
    Produit getProduitById(Long id);
    List<Produit> getAllProduits();
    List<Produit> findProuitsByCategory(String category);
    void updateProduitQuantity(Produit produit1, CommandeItems commandeItems);

}
