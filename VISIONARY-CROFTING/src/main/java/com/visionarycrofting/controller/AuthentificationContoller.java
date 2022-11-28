package com.visionarycrofting.controller;

import com.visionarycrofting.entity.Client;
import com.visionarycrofting.entity.Fornisseur;
import com.visionarycrofting.entity.Stock;
import com.visionarycrofting.service.IService.IClientService;
import com.visionarycrofting.service.IService.IFornisseurService;
import com.visionarycrofting.service.IService.IStockService;
import com.visionarycrofting.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/login")
public class AuthentificationContoller {

    @Autowired
    IStockService stockService;

    @Autowired
    IClientService clientService;

    @Autowired
    IFornisseurService fornisseurService;

    @PostMapping("/stock/email/{email}/password/{password}")
    public Object Stocklogin(@PathVariable String email, @PathVariable String password) {
        Stock stock = stockService.findByEmail(email);
        if(stock == null){
            return "ce stock n'exist pas";
        }
       if (stock.getEmail().equals(email) && stock.getPassword().equals(password)) {
            return stock;
        }
       else {
           return "Mot de passe est incorrect";
       }
    }

    @PostMapping("/client/email/{email}/password/{password}")
    public Object clientLogin(@PathVariable String email, @PathVariable String password){
        Client client = clientService.findByEmail(email);
        if(client == null){
            return "ce client n'exist pas";
        }
        if (client.getEmail().equals(email) && client.getPassword().equals(password)) {
            return client;
        }
        else {
            return "Mot de passe est incorrect";
        }
    }

    @PostMapping("/fornisseur/email/{email}/password/{password}")
    public Object fornisseurLogin(@PathVariable String email, @PathVariable String password){
        Fornisseur fornisseur = fornisseurService.findByEmail(email);
        if(fornisseur == null){
            return "ce fornisseur n'exist pas";
        }
        if (fornisseur.getEmail().equals(email) && fornisseur.getPassword().equals(password)) {
            return fornisseur;
        }
        else {
            return "Mot de passe est incorrect";
        }
    }
}
