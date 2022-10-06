package com.spring.desafio.service;

import com.spring.desafio.controller.dto.ClientResponseDTO;
import com.spring.desafio.entity.Cliente;
import com.spring.desafio.exception.FileNotFoundException;

import java.util.List;

public interface IClientService {
    List<ClientResponseDTO> getAll() throws FileNotFoundException;

    List<ClientResponseDTO> getAllClientsByState(String state) throws FileNotFoundException;
}
