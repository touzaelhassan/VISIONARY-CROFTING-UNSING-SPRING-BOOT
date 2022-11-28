package com.visionarycrofting.service.IService;

import com.visionarycrofting.entity.Commande;
import org.springframework.stereotype.Service;

@Service
public interface ICommandeService {
    Commande save(Commande commande);
}
