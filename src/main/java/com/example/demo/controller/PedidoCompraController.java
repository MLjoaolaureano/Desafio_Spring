package com.example.demo.controller;


import com.example.demo.entity.PedidoCompra;
import com.example.demo.entity.TicketCompra;
import com.example.demo.exception.FileNotFoundException;
import com.example.demo.exception.ProdutoNotExistsException;
import com.example.demo.exception.ProdutoQuantityNotSufficientException;
import com.example.demo.service.IPedidoCompraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("purchase-request")
public class PedidoCompraController {

    IPedidoCompraService pedidoCompraService;

    PedidoCompraController(IPedidoCompraService pedidoCompraService) {
        this.pedidoCompraService = pedidoCompraService;
    }

    @PostMapping
    public ResponseEntity<TicketCompra> purchaseRequest(@RequestBody List<PedidoCompra> payload) throws ProdutoNotExistsException, FileNotFoundException, ProdutoQuantityNotSufficientException {
        TicketCompra ticket = this.pedidoCompraService.createPedidoCompra(payload);
        return ResponseEntity.ok(ticket);
    }
}
