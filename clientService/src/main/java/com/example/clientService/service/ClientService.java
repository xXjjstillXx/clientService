package com.example.clientService.service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.clientService.model.ClientModel;
import com.example.clientService.repository.ClientRepository;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    public ClientModel create(String nombre, String apellido, String fechaNacimiento){
        ClientModel c = new ClientModel();
        c.setNombre(nombre);
        c.setApellido(apellido);
        c.setFechaNacimiento(LocalDate.parse(fechaNacimiento));
        return this.clientRepository.save(c);
    }

    public String findById(long id){
        JSONObject result = null;
        Optional<ClientModel> cajaCliente = this.clientRepository.findById(id);
        if(cajaCliente.isPresent()){
            ClientModel c = cajaCliente.get();
            String descripcionClient = "{ \n" + 
                                    "\"id\": " + c.getId() + "," + 
                                    "\"nombre\": " + "\"" +  c.getNombre()+ "\"" + "," + 
                                    "\"apellido\": " + "\"" + c.getApellido() + "\"" + "," +
                                    "\"edad\": " + "\"" + this.calcularEdad(c.getFechaNacimiento()) + "\"" +
                                    "}";
            try{
                result = new JSONObject(descripcionClient);
            }catch(JSONException e){
                e.printStackTrace();
            }
        }
        return result.toString();
    }

    public int calcularEdad(LocalDate fechaNacimiento){
        DateTimeFormatter fnt = DateTimeFormatter.ofPattern("yyy-MM-dd");
        LocalDate fechaNac = LocalDate.parse(fechaNacimiento.toString(),fnt);
        LocalDate ahora = LocalDate.now();
        Period periodo = Period.between(fechaNac, ahora); 
        return periodo.getYears();
    }

    
    
}
