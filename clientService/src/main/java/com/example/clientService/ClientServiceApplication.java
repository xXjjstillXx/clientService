package com.example.clientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.clientService.service.ClientService;

@SpringBootApplication
public class ClientServiceApplication {
	
	@Autowired
	ClientService clientService;
	
	public static void main(String[] args) {
		SpringApplication.run(ClientServiceApplication.class, args);
	}



}
