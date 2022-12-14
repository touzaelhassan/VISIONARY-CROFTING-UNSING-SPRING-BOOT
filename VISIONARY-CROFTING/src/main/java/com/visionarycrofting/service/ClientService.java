package com.visionarycrofting.service;

import com.visionarycrofting.entity.Client;
import com.visionarycrofting.repository.IClientRepository;
import com.visionarycrofting.service.IService.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService implements IClientService {
    @Autowired
    IClientRepository clientRepository;

    public Client save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
         clientRepository.deleteById(id);
    }

    @Override
    public Optional<Client> findById(Long id) {
        return clientRepository.findById(id);
    }

    @Override
    public Client findByEmail(String email) {
        return clientRepository.findByEmail(email);

    }

}
