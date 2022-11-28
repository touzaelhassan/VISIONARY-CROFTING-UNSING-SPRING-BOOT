package com.visionarycrofting.service;

import com.visionarycrofting.entity.Stock;
import com.visionarycrofting.repository.IStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {

    @Autowired
    IStockRepository stockRepository;

    public Stock saveStock(Stock stock){
        stockRepository.save(stock);
        return stock;
    }

    public List<Stock> getAllStock(){
        return stockRepository.findAll();
    }

    public Stock updateStock(Stock stock){
        stockRepository.save(stock);
        return stock;
    }

    public Stock findOneStock(int idStock){
        return stockRepository.findById(idStock).get();
    }

    public Stock findByEmail(String email){
        return stockRepository.findByEmail(email);
    }
}
