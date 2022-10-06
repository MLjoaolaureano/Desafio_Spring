package com.spring.desafio.service;

import com.spring.desafio.controller.dto.ClientResponseDTO;
import com.spring.desafio.entity.Cliente;
import com.spring.desafio.exception.ClienteCPFAlreadyExists;
import com.spring.desafio.exception.ClienteIdAlreadyExists;
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
     * Save a new cliente at storage
     *
     * @param newCliente the new Cliente to store
     * @return the new created client
     * @throws FileNotFoundException
     * @throws ClienteIdAlreadyExists
     */
    @Override
    public Cliente create(Cliente newCliente) throws FileNotFoundException, ClienteIdAlreadyExists, ClienteCPFAlreadyExists {
        return clientRepository.create(newCliente);
    }
}
