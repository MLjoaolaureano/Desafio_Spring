package com.spring.desafio.service;

import com.spring.desafio.controller.dto.ClientResponseDTO;
import com.spring.desafio.entity.Client;
import com.spring.desafio.exception.ClientCPFAlreadyExistsException;
import com.spring.desafio.exception.ClientIdAlreadyExistsException;
import com.spring.desafio.exception.FileNotFoundException;

import java.util.List;

public interface IClientService {
    List<ClientResponseDTO> getAll() throws FileNotFoundException;
    Client create(Client newClient) throws FileNotFoundException, ClientIdAlreadyExistsException, ClientCPFAlreadyExistsException;
    List<ClientResponseDTO> getAllClientsByState(String state) throws FileNotFoundException;
}
