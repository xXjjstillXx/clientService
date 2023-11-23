package com.example.clientService.repository;

import com.example.clientService.model.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientModel,Long>{
    
}
