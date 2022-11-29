package com.visionarycrofting.service.IService;

import com.visionarycrofting.entity.Client;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IClientService {

    Client save(Client client);
    List<Client> findAll();
    void deleteById(Long id);

    Optional<Client> findById(Long id);

    Client findByEmail(String email);


}
