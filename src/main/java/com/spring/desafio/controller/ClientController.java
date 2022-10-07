package com.spring.desafio.controller;

import com.spring.desafio.controller.dto.ClientResponseDTO;
import com.spring.desafio.entity.Client;
import com.spring.desafio.exception.ClientCPFAlreadyExistsException;
import com.spring.desafio.exception.ClientIdAlreadyExistsException;
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
     * POST endpoint to store a {@link Client}.
     *
     * @param client
     * @return ResponseEntity<Client> to the requester
     * @throws ClientIdAlreadyExistsException
     * @throws FileNotFoundException
     */
    @PostMapping("/insert-client-request")
    public ResponseEntity<ClientResponseDTO> saveCliente(@RequestBody Client client) throws ClientIdAlreadyExistsException, FileNotFoundException, ClientCPFAlreadyExistsException {
        Client newClient = this.clientService.create(client);
        ClientResponseDTO responseClienteDTO = new ClientResponseDTO(newClient);
        return new ResponseEntity<>(responseClienteDTO, HttpStatus.CREATED);
    }
    @GetMapping("/filter")
    public ResponseEntity<List<ClientResponseDTO>> getAllClientsByState(@RequestParam String state) throws IOException {
        return ResponseEntity.ok(this.clientService.getAllClientsByState(state));
    }
}