package com.spring.desafio.service;

import com.spring.desafio.controller.dto.ClientResponseDTO;
import com.spring.desafio.entity.Client;
import com.spring.desafio.exception.ClientCPFAlreadyExists;
import com.spring.desafio.exception.ClientIdAlreadyExists;
import com.spring.desafio.exception.FileNotFoundException;

import java.util.List;

public interface IClientService {
    List<ClientResponseDTO> getAll() throws FileNotFoundException;
    Client create(Client newClient) throws FileNotFoundException, ClientIdAlreadyExists, ClientCPFAlreadyExists;
    List<ClientResponseDTO> getAllClientsByState(String state) throws FileNotFoundException;
}
