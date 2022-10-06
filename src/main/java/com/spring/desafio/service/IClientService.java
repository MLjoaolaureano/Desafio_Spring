package com.spring.desafio.service;

import com.spring.desafio.controller.dto.ClientResponseDTO;
import com.spring.desafio.entity.Cliente;
import com.spring.desafio.exception.ClienteCPFAlreadyExists;
import com.spring.desafio.exception.ClienteIdAlreadyExists;
import com.spring.desafio.exception.FileNotFoundException;

import java.util.List;

public interface IClientService {
    List<ClientResponseDTO> getAll() throws FileNotFoundException;
    Cliente create(Cliente newCliente) throws FileNotFoundException, ClienteIdAlreadyExists, ClienteCPFAlreadyExists;
    List<ClientResponseDTO> getAllClientsByState(String state) throws FileNotFoundException;
}
