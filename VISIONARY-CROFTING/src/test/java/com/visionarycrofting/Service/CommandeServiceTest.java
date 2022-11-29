package com.visionarycrofting.Service;

import com.visionarycrofting.entity.Commande;
import com.visionarycrofting.service.CommandeService;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CommandeServiceTest {

    @Autowired
    CommandeService commandeService;

    Commande commande = new Commande();

    @Test
    void findByReference() {
        var ref = "F2LEE9YA";
        assertThat(ref).isInstanceOf(String.class).isNotNull();
        assertThat(commandeService.findByReference(ref)).isNotNull();

    }
}