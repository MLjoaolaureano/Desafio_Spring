package com.spring.desafio.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.spring.desafio.entity.Client;
import com.spring.desafio.exception.ClientCPFAlreadyExistsException;
import com.spring.desafio.exception.ClientIdAlreadyExistsException;
import com.spring.desafio.exception.FileNotFoundException;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository implements IClientRepository {

    private final String fileClient = "src/main/resources/clients.json";

    ObjectMapper mapper = new ObjectMapper();

    ObjectWriter writer = mapper.writer();

    @Override
    public List<Client> getAll() throws FileNotFoundException {

        File storeFile = new File(fileClient);
        List<Client> clients = null;
        try {
            clients = Arrays.asList(mapper.readValue(storeFile, Client[].class));
        } catch (IOException e) {
            throw new FileNotFoundException("Arquivo não encontrado.");
        }
        return clients;
    }

    /**
     * Store a new {@link Client} and returns the new created entity
     *
     * @param newClient
     * @return the new Client stored
     * @throws FileNotFoundException
     * @throws ClientIdAlreadyExistsException if CPF or ID already exists
     */
    public Client create(Client newClient) throws FileNotFoundException, ClientIdAlreadyExistsException, ClientCPFAlreadyExistsException {
        File storeFile = new File(fileClient);
        List<Client> clients = null;
        try {
            clients = Arrays.asList(mapper.readValue(storeFile, Client[].class));
            Optional<Client> optionalClient = clients.stream()
                    .filter((c) -> c.getClientId().equals(newClient.getClientId()) ||
                            c.getCpf().equalsIgnoreCase(newClient.getCpf()))
                    .findAny();
            if (optionalClient.isPresent()) {
                Client existentClient = optionalClient.get();
                if (existentClient.getCpf().equalsIgnoreCase(newClient.getCpf()))
                    throw new ClientCPFAlreadyExistsException(String.format("Cliente com CPF [%s] já existente", newClient.getCpf()));
                if (existentClient.getClientId().equals(newClient.getClientId()))
                    throw new ClientIdAlreadyExistsException(String.format("Cliente com ID [%d] já existente", newClient.getClientId()));
            }
            List<Client> wholeList = new ArrayList<>(this.getAll());
//            wholeList.add();
            wholeList.add(newClient);
            writer.writeValue(storeFile, wholeList);

            return newClient;
        } catch (IOException e) {
            throw new FileNotFoundException("Arquivo não encontrado.");
        }

    }

}
