package com.visionarycrofting.service;

import com.visionarycrofting.entity.Produit;
import com.visionarycrofting.repository.IproduitRepository;
import com.visionarycrofting.service.IService.IProduitService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitService implements IProduitService {

    IproduitRepository iproduitRepository;

    public ProduitService(IproduitRepository iproduitRepository) { this.iproduitRepository = iproduitRepository; }

    @Override
    public Produit addProduit(Produit produit) { return iproduitRepository.save(produit); }

    @Override
    public Produit updateProduit(Produit produit,Long produitId) {

        Produit DBProduit = iproduitRepository.findById(produitId).orElse(null);

        DBProduit.setCategory(produit.getCategory());

        return iproduitRepository.save(DBProduit);

    }

    @Override
    public Produit getProduitById(Long id) {
        return iproduitRepository.findById(id).orElse(null);
    }

    @Override
    public List<Produit> getAllProduits() { return iproduitRepository.findAll(); }

    @Override
    public List<Produit> findProuitsByCategory(String category) {
        return  iproduitRepository.findByCategory(category);
    }

}
