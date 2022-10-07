package com.spring.desafio.repository;

import com.spring.desafio.entity.Client;
import com.spring.desafio.exception.ClientCPFAlreadyExistsException;
import com.spring.desafio.exception.ClientIdAlreadyExistsException;
import com.spring.desafio.exception.FileNotFoundException;

import java.util.List;

public interface IClientRepository {
    List<Client> getAll() throws FileNotFoundException;
    Client create(Client newClient) throws FileNotFoundException, ClientIdAlreadyExistsException, ClientCPFAlreadyExistsException;
}
