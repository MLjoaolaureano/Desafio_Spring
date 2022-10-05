package com.example.demo.service;

import com.example.demo.entity.PedidoCompra;
import com.example.demo.entity.TicketCompra;
import com.example.demo.exception.FileNotFoundException;
import com.example.demo.exception.ProdutoNotExistsException;

import java.util.List;

public interface IPedidoCompraService {
    
    public TicketCompra createPedidoCompra(List<PedidoCompra> pedidoCompra) throws ProdutoNotExistsException, FileNotFoundException;
    
}
