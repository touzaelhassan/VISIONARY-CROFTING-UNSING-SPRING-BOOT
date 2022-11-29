package com.visionarycrofting.service;

import com.visionarycrofting.entity.CommandeItems;
import com.visionarycrofting.repository.ICommandeItemRepository;
import com.visionarycrofting.service.IService.ICommandeItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandeItemService implements ICommandeItemService {
    @Autowired
    ICommandeItemRepository commandeItemRepository;

    @Override
    public CommandeItems save(CommandeItems commandeItems) {
        return commandeItemRepository.save(commandeItems);
    }

    @Override
    public void deleteByRef(String ref) {
        commandeItemRepository.deleteByReference(ref);
    }

    @Override
    public CommandeItems findByRef(String ref) {
        return commandeItemRepository.findCommandeItemsByReference(ref);
    }

    @Override
    public List<CommandeItems> findAll() {
        return commandeItemRepository.findAll();
    }
}
