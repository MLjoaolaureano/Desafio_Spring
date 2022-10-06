package com.spring.desafio.controller;

import com.spring.desafio.controller.dto.ClientResponseDTO;
import com.spring.desafio.entity.Cliente;
import com.spring.desafio.exception.ClienteCPFAlreadyExists;
import com.spring.desafio.exception.ClienteIdAlreadyExists;
import com.spring.desafio.exception.FileNotFoundException;
import com.spring.desafio.service.IClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    /**
     * POST endpoint to store a {@link Cliente}.
     *
     * @param cliente
     * @return ResponseEntity<Cliente> to the requester
     * @throws ClienteIdAlreadyExists
     * @throws FileNotFoundException
     */
    @PostMapping("/insert-client-request")
    public ResponseEntity<ClientResponseDTO> saveCliente(@RequestBody Cliente cliente) throws ClienteIdAlreadyExists, FileNotFoundException, ClienteCPFAlreadyExists {
        Cliente newCliente = this.clientService.create(cliente);
        ClientResponseDTO responseClienteDTO = new ClientResponseDTO(newCliente);
        return new ResponseEntity<>(responseClienteDTO, HttpStatus.CREATED);
    }
    @GetMapping("/filter")
    public ResponseEntity<List<ClientResponseDTO>> getAllClientsByState(@RequestParam String state) throws IOException {
        return ResponseEntity.ok(this.clientService.getAllClientsByState(state));
    }
}