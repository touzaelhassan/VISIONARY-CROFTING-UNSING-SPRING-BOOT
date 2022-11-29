package com.visionarycrofting.controller;

import com.visionarycrofting.entity.Produit;
import com.visionarycrofting.service.ProduitService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produits")
public class ProduitController {

    ProduitService produitService;

    public ProduitController(ProduitService produitService) { this.produitService = produitService; }

    @PostMapping("/create")
    public Produit addProduit(@RequestBody Produit produit){
        return produitService.addProduit(produit);
    }

    @PostMapping("/update/{produitId}")
    public Produit updateProduit(@RequestBody Produit produit, @PathVariable Long produitId){
        return produitService.updateProduit(produit, produitId);
    }

    @GetMapping("")
    public List<Produit> getAllProduits(){ return produitService.getAllProduits(); }

    @GetMapping("/produit/{produitId}")
    public Produit getProduitById(@PathVariable Long produitId){ return produitService.getProduitById(produitId); }

    @GetMapping("/{category}")
    public List<Produit> getAllProduitsByCategory(@PathVariable String category){
        return produitService.findProuitsByCategory(category);
    }



}
