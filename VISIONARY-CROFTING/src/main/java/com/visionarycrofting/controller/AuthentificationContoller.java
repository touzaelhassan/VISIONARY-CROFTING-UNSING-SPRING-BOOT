package com.visionarycrofting.controller;

import com.visionarycrofting.entity.Stock;
import com.visionarycrofting.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/login")
public class AuthentificationContoller {
    @Autowired
    StockService stockService;
    @PostMapping("/stock/email/{email}/password/{password}")
    public Object Stocklogin(@PathVariable String email, @PathVariable String password) {
        Stock stock = stockService.findByEmail(email);
        if(stock == null){
            return "ce stock n'est exist pas";
        }
       if (stock.getEmail().equals(email) && stock.getPassword().equals(password)) {
            return stock;
        }
       else {
           System.out.println("");
           return "Mot de passe est incorrect";
       }
    }

}
