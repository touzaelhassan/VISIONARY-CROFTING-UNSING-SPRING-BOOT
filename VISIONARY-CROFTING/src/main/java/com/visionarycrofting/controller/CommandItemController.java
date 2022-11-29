package com.visionarycrofting.controller;

import com.visionarycrofting.entity.Commande;
import com.visionarycrofting.entity.CommandeItems;
import com.visionarycrofting.service.IService.ICommandeItemService;
import com.visionarycrofting.service.IService.ICommandeService;
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


    @GetMapping("/all_items")
    public List<CommandeItems> findAll(){
        return commandeItemService.findAll();
    }


    @GetMapping("/add-commande-items/commande/{id}")
    public void save(@RequestBody CommandeItems commandeItems,@PathVariable Long id){
        Commande commande= commandeService.findById(id).get();
        commandeItems.setCommande(commande);
        commandeItems.setReference(GenerateReference.applyGenerateReference());
        commandeItemService.save(commandeItems);
        updateCommandePrix(commande);
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
