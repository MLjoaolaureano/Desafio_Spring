package com.spring.desafio.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.spring.desafio.entity.Cliente;
import com.spring.desafio.exception.ClienteCPFAlreadyExists;
import com.spring.desafio.exception.ClienteIdAlreadyExists;
import com.spring.desafio.exception.FileNotFoundException;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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

    /**
     * Store a new {@link Cliente} and returns the new created entity
     *
     * @param newCliente
     * @return the new Cliente stored
     * @throws FileNotFoundException
     * @throws ClienteIdAlreadyExists if CPF or ID already exists
     */
    public Cliente create(Cliente newCliente) throws FileNotFoundException, ClienteIdAlreadyExists, ClienteCPFAlreadyExists {
        File storeFile = new File(fileClient);
        List<Cliente> clients = null;
        try {
            clients = Arrays.asList(mapper.readValue(storeFile, Cliente[].class));
            Optional<Cliente> clienteOptional = clients.stream()
                    .filter((c) -> c.getClientId().equals(newCliente.getClientId()) ||
                            c.getCpf().equalsIgnoreCase(newCliente.getCpf()))
                    .findAny();
            if (clienteOptional.isPresent()) {
                Cliente existentClient = clienteOptional.get();
                if (existentClient.getCpf().equalsIgnoreCase(newCliente.getCpf()))
                    throw new ClienteCPFAlreadyExists(String.format("Cliente com CPF [%s] já existente", newCliente.getCpf()));
                if (existentClient.getClientId().equals(newCliente.getClientId()))
                    throw new ClienteIdAlreadyExists(String.format("Cliente com ID [%d] já existente", newCliente.getClientId()));
            }
            writer.writeValue(storeFile, newCliente);

            return newCliente;
        } catch (IOException e) {
            throw new FileNotFoundException("Arquivo não encontrado.");
        }

    }

}
