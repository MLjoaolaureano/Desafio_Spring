package com.spring.desafio.service;

import com.spring.desafio.controller.dto.ClientResponseDTO;
import com.spring.desafio.entity.Client;
import com.spring.desafio.exception.ClientCPFAlreadyExists;
import com.spring.desafio.exception.ClientIdAlreadyExists;
import com.spring.desafio.exception.FileNotFoundException;
import com.spring.desafio.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService implements IClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<ClientResponseDTO> getAll() throws FileNotFoundException {
        return ClientResponseDTO.toDTOList(this.clientRepository.getAll());
    }

    /**
     * Save a new client at storage
     *
     * @param newClient the new Client to store
     * @return the new created client
     * @throws FileNotFoundException
     * @throws ClientIdAlreadyExists
     */
    @Override
    public Client create(Client newClient) throws FileNotFoundException, ClientIdAlreadyExists, ClientCPFAlreadyExists {
        return clientRepository.create(newClient);
    }
        public List<ClientResponseDTO> getAllClientsByState (String state) throws FileNotFoundException {
            return ClientResponseDTO.toDTOList(this.clientRepository.getAll()
                    .stream()
                    .filter(c -> c.getState().equalsIgnoreCase(state)).toList());
        }
    }
