package com.visionarycrofting.controller;

import com.visionarycrofting.entity.Commande;
import com.visionarycrofting.entity.CommandeItems;
import com.visionarycrofting.entity.Produit;
import com.visionarycrofting.service.IService.ICommandeItemService;
import com.visionarycrofting.service.IService.ICommandeService;
import com.visionarycrofting.service.IService.IProduitService;
import com.visionarycrofting.utils.GenerateReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;


@RestController
@RequestMapping("/commandes")
public class CommandItemController {

    @Autowired
    ICommandeItemService commandeItemService;

    @Autowired
    ICommandeService commandeService;

    @Autowired
    IProduitService produitService;


    @GetMapping("/all_items")
    public List<CommandeItems> findAll(){
        return commandeItemService.findAll();
    }


    @GetMapping("/add-commande-items/commande/{id}/produit/{produit}")
    public void save(@RequestBody CommandeItems commandeItems,@PathVariable Long id,@PathVariable Long produit){
        Produit produit1 = produitService.getProduitById(produit);
        Commande commande= commandeService.findById(id).get();
        if(produit1 !=null ||commande !=null) {
            commandeItems.setPrix(produit1.getPrix_initial() * Long.parseLong(commandeItems.getQuantity()));
            commandeItems.setCommande(commande);
            commandeItems.setProduit(produit1);
            commandeItems.setReference(GenerateReference.applyGenerateReference());
            commandeItemService.save(commandeItems);
            updateCommandePrix(commande);
            produitService.updateProduitQuantity(produit1, commandeItems);
        }else{
            throw new IllegalStateException("Un erreur est Servenue !");
        }

    }

    @Transactional
    @DeleteMapping("/commande/{id}/delete_item/{ref}")
    public void deleteByRef(@PathVariable Long id ,@PathVariable String ref){
        commandeItemService.deleteByRef(ref);
        if(commandeItemService.findByRef(ref)==null){
            Commande commande= commandeService.findById(id).get();
            updateCommandePrix(commande);
        }

    }

    @GetMapping("/quantity/{quantity}")
    public List<CommandeItems> getCommandeItemByQuantityGreaterThan(@PathVariable int quantity){
        return commandeItemService.getCommandeItemByQuantityGreaterThan(quantity);
    }






    public void updateCommandePrix( Commande commande){
        List<CommandeItems> items= commande.getCommandeItems();
        Float prix= (float) 0;
        for(CommandeItems item : items){
            System.out.println(item.getReference());
            prix+=item.getPrix();
        }
        System.out.println(prix);
        commande.setPrixTotal(prix);
        commandeService.save(commande);
    }




}
