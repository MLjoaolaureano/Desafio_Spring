package com.spring.desafio.service;

import com.spring.desafio.entity.PedidoCompra;
import com.spring.desafio.entity.TicketCompra;
import com.spring.desafio.exception.FileNotFoundException;
import com.spring.desafio.exception.ProdutoNotExistsException;
import com.spring.desafio.exception.ProdutoQuantityNotSufficientException;

import java.util.List;

public interface IPedidoCompraService {
    
    TicketCompra createPedidoCompra(List<PedidoCompra> pedidoCompra) throws ProdutoNotExistsException, FileNotFoundException, ProdutoQuantityNotSufficientException;
    
}
