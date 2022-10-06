package com.spring.desafio.controller.dto;

import com.spring.desafio.entity.Cliente;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ClientResponseDTO {

    private String name;
    private String state;

    private Long clientId;

    public ClientResponseDTO(Cliente cliente) {
        this.name = cliente.getName();
        this.state = cliente.getState();
        this.clientId = cliente.getClientId();
    }

    public static List<ClientResponseDTO> toDTOList(List<Cliente> clienteList) {
        List<ClientResponseDTO> clientResponseDTOList = new ArrayList<>();
        clienteList.forEach((c) -> clientResponseDTOList.add(new ClientResponseDTO(c)));
        return clientResponseDTOList;
    }
}
