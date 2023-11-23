package com.example.clientService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.clientService.model.ClientModel;
import com.example.clientService.service.ClientService;

@RequestMapping(path = "api/clients")
@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/")
    public ResponseEntity<ClientModel> create(@RequestParam String nombre, @RequestParam String apellido,@RequestParam String fechaNacimiento){
        return new ResponseEntity<>(this.clientService.create(nombre,apellido,fechaNacimiento) , HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return new ResponseEntity<>(this.clientService.findById(id) , HttpStatus.OK);
    }
}
