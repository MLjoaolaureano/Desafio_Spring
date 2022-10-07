package com.spring.desafio.repository;

import com.spring.desafio.entity.Client;
import com.spring.desafio.exception.ClientCPFAlreadyExists;
import com.spring.desafio.exception.ClientIdAlreadyExists;
import com.spring.desafio.exception.FileNotFoundException;

import java.util.List;

public interface IClientRepository {
    List<Client> getAll() throws FileNotFoundException;
    Client create(Client newClient) throws FileNotFoundException, ClientIdAlreadyExists, ClientCPFAlreadyExists;
}
