package com.spring.desafio.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.spring.desafio.entity.Cliente;
import com.spring.desafio.exception.FileNotFoundException;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Repository
public class ClientRepository implements IClientRepository {

    private final String fileClient = "src/main/resources/clients.json";

    ObjectMapper mapper = new ObjectMapper();

    ObjectWriter writer = mapper.writer();

    @Override
    public List<Cliente> getAll() throws FileNotFoundException {

        File storeFile = new File(fileClient);
        List<Cliente> clients = null;
        try {
            clients = Arrays.asList(mapper.readValue(storeFile, Cliente[].class));
        } catch (IOException e) {
            throw new FileNotFoundException("Arquivo não encontrado.");
        }
        return clients;
    }

}
