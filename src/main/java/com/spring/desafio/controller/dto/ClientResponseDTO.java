package com.spring.desafio.controller.dto;

import com.spring.desafio.entity.Client;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ClientResponseDTO {

    private String name;
    private String state;

    private Long clientId;

    public ClientResponseDTO(Client client) {
        this.name = client.getName();
        this.state = client.getState();
        this.clientId = client.getClientId();
    }

    public static List<ClientResponseDTO> toDTOList(List<Client> clientList) {
        List<ClientResponseDTO> clientResponseDTOList = new ArrayList<>();
        clientList.forEach((c) -> clientResponseDTOList.add(new ClientResponseDTO(c)));
        return clientResponseDTOList;
    }
}
