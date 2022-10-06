package com.spring.desafio.repository;

import com.spring.desafio.entity.Cliente;
import com.spring.desafio.exception.ClienteCPFAlreadyExists;
import com.spring.desafio.exception.ClienteIdAlreadyExists;
import com.spring.desafio.exception.FileNotFoundException;

import java.util.List;

public interface IClientRepository {
    List<Cliente> getAll() throws FileNotFoundException;
    Cliente create(Cliente newCliente) throws FileNotFoundException, ClienteIdAlreadyExists, ClienteCPFAlreadyExists;
}
