package com.spring.desafio.controller;

import com.spring.desafio.controller.dto.ClientResponseDTO;
import com.spring.desafio.service.IClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/client")
public class ClientController {

    private final IClientService clientService;

    public ClientController(IClientService clientService) {
        this.clientService = clientService;
    }


    @GetMapping()
    public ResponseEntity<List<ClientResponseDTO>> getAllClients() throws IOException {
        return ResponseEntity.ok(this.clientService.getAll());
    }

    @GetMapping("/filter")
    public ResponseEntity<List<ClientResponseDTO>> getAllClientsByState(@RequestParam("state") String state) throws IOException {
        return ResponseEntity.ok(this.clientService.getAllClientsByState(state));
    }
}