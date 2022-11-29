package com.visionarycrofting.repository;

import com.visionarycrofting.entity.Client;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface IClientRepository extends JpaRepository<Client, Long> {

    public Client findByEmail(String email);
}
