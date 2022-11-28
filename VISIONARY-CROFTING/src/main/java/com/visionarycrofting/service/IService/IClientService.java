package com.visionarycrofting.service.IService;

import com.visionarycrofting.entity.Client;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IClientService {

    Client save(Client client);
    List<Client> findAll();
    void deleteById(Long id);

}
