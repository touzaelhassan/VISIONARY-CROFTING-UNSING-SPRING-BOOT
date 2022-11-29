package com.visionarycrofting.Service;

import com.visionarycrofting.entity.Commande;
import com.visionarycrofting.entity.CommandeItems;
import com.visionarycrofting.service.CommandeItemService;
import com.visionarycrofting.service.CommandeService;
import com.visionarycrofting.utils.GenerateReference;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CommandeItemServiceTest {

    @Autowired
    CommandeItemService commandeItemService;

    @Autowired
    CommandeService commandeService ;


    CommandeItems commandeItems = new CommandeItems();


    @Test
    void save() {
        int commandeItemsListFirst = commandeItemService.findAll().size();
        System.out.println(commandeItemsListFirst);
        commandeItems.setReference(GenerateReference.applyGenerateReference());
        commandeItems.setPrix(19f);
        commandeItems.setQuantity(6);
        Commande commande = commandeService.findByReference("F2LEE9YA");
        assertThat(commande).isNotNull();
        commandeItems.setCommande(commande);
        assertThat(commandeItems.getPrix()).isGreaterThan(0).isNotNull();
        assertThat(commandeItems.getQuantity()).isGreaterThan(0).isNotNull();
        assertThat(commandeItems.getReference()).isNotNull().isNotEmpty();
 /**/   commandeItemService.save(commandeItems);
        int commandeItemsListLatest = commandeItemService.findAll().size();
        System.out.println(commandeItemsListLatest);
        assertThat(commandeItemsListFirst).isEqualTo(commandeItemsListLatest-1);
    }
}