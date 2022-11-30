package com.visionarycrofting.Service;

import com.visionarycrofting.entity.AppelOffre;
import com.visionarycrofting.entity.Commande;
import com.visionarycrofting.entity.StatusAppelOffre;
import com.visionarycrofting.entity.Stock;
import com.visionarycrofting.service.AppelOffreService;
import com.visionarycrofting.service.StockService;
import com.visionarycrofting.utils.GenerateReference;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class AppelOffreServiceTest {

    @Autowired
    AppelOffreService appelOffreService;

    AppelOffre appelOffre = new AppelOffre();
    @Autowired
    StockService stockService;
    @Test
    void save() {
        int appelOffreListFirst = appelOffreService.getAppelOffres().size();
        appelOffre.setId(10);
        appelOffre.setReference("AAZ222");
        appelOffre.setStatusAppelOffre(StatusAppelOffre.OUVERTE);
        Stock stock = stockService.findOneStock(1);
        assertThat(stock).isNotNull();
        appelOffre.setStock(stock);

        //check the attributs
        assertThat(appelOffre.getStatusAppelOffre()).isNotNull();
        assertThat(appelOffre.getStock()).isNotNull();
        assertThat(appelOffre.getReference()).isNotNull().isNotEmpty();
        assertThat(appelOffre.getId()).isNotNull().isGreaterThan(0);
        /**/   appelOffreService.addAppelOffre(appelOffre);

        int appelOffreListLast = appelOffreService.getAppelOffres().size();
        assertThat(appelOffreListLast).isNotEqualTo(appelOffreListFirst);
    }
    @Test
    void deleteAppelOffre() {
        AppelOffre appelOffre = appelOffreService.findById(1).get();
        assertThat(appelOffre).isNotNull();
        appelOffreService.deleteAppelOffre(1);
        assertThat(appelOffreService.findById(1).get()).isNull();


    }
}