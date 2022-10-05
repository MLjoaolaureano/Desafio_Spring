package com.example.demo.service;

import com.example.demo.entity.PedidoCompra;
import com.example.demo.entity.Produto;
import com.example.demo.entity.TicketCompra;
import com.example.demo.exception.FileNotFoundException;
import com.example.demo.exception.ProdutoNotExistsException;
import com.example.demo.exception.ProdutoQuantityNotSufficientException;
import com.example.demo.repository.IProdutoRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PedidoCompraService implements IPedidoCompraService{

    private final IProdutoRepository produtoRepository;

    public PedidoCompraService(IProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }
    @Override
    public TicketCompra createPedidoCompra(List<PedidoCompra> pedidoCompraList) throws ProdutoNotExistsException, FileNotFoundException, ProdutoQuantityNotSufficientException {
        Set<Produto> produtoSet = new HashSet<>();
        BigDecimal totalValor = BigDecimal.valueOf(0.0);

        for(PedidoCompra compra: pedidoCompraList){
            Produto produto = this.produtoRepository.getProdutoById(compra.getProductId());
            if(produto.getQuantity() < compra.getQuantity()){
                throw new ProdutoQuantityNotSufficientException("Estoque de produto é insuficiente");
            }
            else{

                produtoSet.add(produto);
                totalValor = totalValor.add(produto.getPrice().multiply(BigDecimal.valueOf(compra.getQuantity())));

            }
        }

        TicketCompra novoTicket = new TicketCompra(produtoSet.stream().toList(), totalValor);

        return novoTicket;
    }
}
