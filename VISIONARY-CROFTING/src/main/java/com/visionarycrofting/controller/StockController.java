package com.visionarycrofting.controller;

import com.visionarycrofting.entity.Stock;
import com.visionarycrofting.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/stock")
public class StockController {

    @Autowired
    StockService stockService;

    @GetMapping("/")
    public List<Stock> getAllStocks(){
        return stockService.getAllStock();
    }

    @PostMapping("/")
    public Stock saveStock(@RequestBody Stock stock){
        return stockService.saveStock(stock);
    }

    @PutMapping("/update/id/{idStock}")
    public Stock updateStock(@RequestBody Stock stock,@PathVariable int idStock){
        Stock stock1 = stockService.findOneStock(idStock);
        stock1.setAdresse(stock.getAdresse());
        stock1.setEmail(stock.getEmail());
        stock1.setNom(stock.getNom());
        stock1.setPassword(stock.getPassword());
        stock1.setTelephone(stock.getTelephone());
        stock1.setAppeleOffres(stock.getAppeleOffres());
        return stockService.updateStock(stock1);
    }

    @GetMapping("/OneStock/id/{idStock}")
    public Stock findOneStock(@PathVariable int idStock){
        return stockService.findOneStock(idStock);
    }
}
