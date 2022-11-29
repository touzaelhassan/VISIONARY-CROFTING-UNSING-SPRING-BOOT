package com.visionarycrofting.Service;

import com.visionarycrofting.entity.Stock;
import com.visionarycrofting.service.StockService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class StockServiceTest {

    @Autowired
    StockService stockService;

    @Test
    void updateStock() {
        Stock stockOld=null;
        String nom ="FDFGD";
        String adresse ="csGDGDcsc";
        String email ="stock22@gmail.com";
        String tele = "423242424";
        String password ="242424234";

       Stock stock = stockService.findOneStock(14);
        assertThat(stock).isNotNull();
        stockOld = stockService.findOneStock(14);
        assertThat(nom).isNotEmpty().isNotNull();
        assertThat(adresse).isNotEmpty().isNotNull();
        assertThat(email).isNotEmpty().isNotNull();
        assertThat(tele).isNotEmpty().isNotNull();
        assertThat(password).isNotEmpty().isNotNull();

        stock.setNom(nom);
        stock.setEmail(email);
        stock.setAdresse(adresse);
        stock.setPassword(password);
        stock.setTelephone(tele);
        Stock stockLatest= stockService.updateStock(stock);
        assertThat(stockLatest).isNotEqualTo(stockOld);

    }
}