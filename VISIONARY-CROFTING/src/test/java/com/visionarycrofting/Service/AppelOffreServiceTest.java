package com.visionarycrofting.Service;

import com.visionarycrofting.entity.AppelOffre;
import com.visionarycrofting.service.AppelOffreService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class AppelOffreServiceTest {

    @Autowired
    AppelOffreService appelOffreService;

    @Test
    void deleteAppelOffre() {
        AppelOffre appelOffre = appelOffreService.findById(1).get();
        assertThat(appelOffre).isNotNull();
        appelOffreService.deleteAppelOffre(1);
        assertThat(appelOffreService.findById(1).get()).isNull();


    }
}