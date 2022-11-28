package com.visionarycrofting.controller;


import com.visionarycrofting.entity.Client;
import com.visionarycrofting.service.IService.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    IClientService clientService;

    @PostMapping("/register")
    public Client save(@RequestBody Client client) {
        return clientService.save(client);
    }

    @GetMapping("/allclient")
    public List<Client> findAll() {
        return clientService.findAll();
    }

    @Transactional
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id){
         clientService.deleteById(id);
    }


}
