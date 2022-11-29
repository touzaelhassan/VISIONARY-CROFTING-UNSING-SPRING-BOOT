package com.visionarycrofting.repository;


import com.visionarycrofting.entity.CommandeItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommandeItemRepository extends JpaRepository<CommandeItems,Long> {
    public void deleteByReference(String reference);
    public CommandeItems findCommandeItemsByReference(String reference);
}
