package com.spring.desafio.service;

import com.spring.desafio.controller.dto.ClientResponseDTO;
import com.spring.desafio.entity.Client;
import com.spring.desafio.exception.ClientCPFAlreadyExistsException;
import com.spring.desafio.exception.ClientIdAlreadyExistsException;
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
     * @throws ClientIdAlreadyExistsException
     */
    @Override
    public Client create(Client newClient) throws FileNotFoundException, ClientIdAlreadyExistsException, ClientCPFAlreadyExistsException {
        return clientRepository.create(newClient);
    }
        public List<ClientResponseDTO> getAllClientsByState (String state) throws FileNotFoundException {
            return ClientResponseDTO.toDTOList(this.clientRepository.getAll()
                    .stream()
                    .filter(c -> c.getState().equalsIgnoreCase(state)).toList());
        }
    }
