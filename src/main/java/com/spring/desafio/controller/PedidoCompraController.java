package com.spring.desafio.controller;


import com.spring.desafio.entity.PedidoCompra;
import com.spring.desafio.entity.TicketCompra;
import com.spring.desafio.exception.FileNotFoundException;
import com.spring.desafio.exception.ProdutoNotExistsException;
import com.spring.desafio.exception.ProdutoQuantityNotSufficientException;
import com.spring.desafio.service.IPedidoCompraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Main controller for {@link PedidoCompra} entity
 */
@RestController
@RequestMapping("purchase-request")
public class PedidoCompraController {

    IPedidoCompraService pedidoCompraService;

    PedidoCompraController(IPedidoCompraService pedidoCompraService) {
        this.pedidoCompraService = pedidoCompraService;
    }

    /**
     * POST endpoint to receive {@link List<PedidoCompra>} payload from user and returns the ticket created for purchase request
     *
     * @param payload
     * @return the ticket created for the purchase request
     * @throws ProdutoNotExistsException             in case the product does not exist in storage
     * @throws FileNotFoundException
     * @throws ProdutoQuantityNotSufficientException in case the product quantity is not enough in storage
     */
    @PostMapping
    public ResponseEntity<TicketCompra> purchaseRequest(@RequestBody List<PedidoCompra> payload) throws ProdutoNotExistsException, FileNotFoundException, ProdutoQuantityNotSufficientException {
        TicketCompra ticket = this.pedidoCompraService.createPedidoCompra(payload);
        return ResponseEntity.ok(ticket);
    }
}
