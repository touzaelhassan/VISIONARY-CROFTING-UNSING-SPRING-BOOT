package com.visionarycrofting.Service;

import com.visionarycrofting.entity.Category;
import com.visionarycrofting.entity.Produit;
import com.visionarycrofting.service.IService.IProduitService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProduitServiceTest {

    @Autowired
    IProduitService iProduitService;

    @Test
    void addProduit() {


        int produitNumbers = iProduitService.getAllProduits().size();

        Produit produit = new Produit();

        produit.setNom("Produit test");
        produit.setDescription("Produit test description");
        produit.setPrix_initial(223F);
        produit.setReference("746464");
        produit.setQuantity(25);
        produit.setCategory(Category.LEGUMES);

        assertThat(produit.getNom()).isNotEmpty().isNotNull();
        assertThat(produit.getDescription()).isNotEmpty().isNotNull();
        assertThat(produit.getReference()).isNotEmpty().isNotNull();
        assertThat(produit.getPrix_initial()).isGreaterThan(0).isNotNull();
        assertThat(produit.getQuantity()).isGreaterThan(0).isNotNull();
        assertThat(produit.getCategory()).isExactlyInstanceOf(Category.class).isNotNull();

        iProduitService.addProduit(produit);

        int produitNumbersAfter = iProduitService.getAllProduits().size();


        assertThat(produitNumbers).isNotEqualTo(produitNumbersAfter);


    }



}