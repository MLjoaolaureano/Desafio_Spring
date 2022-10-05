package com.spring.desafio.service;

import com.spring.desafio.entity.PedidoCompra;
import com.spring.desafio.entity.Produto;
import com.spring.desafio.entity.TicketCompra;
import com.spring.desafio.exception.FileNotFoundException;
import com.spring.desafio.exception.ProdutoNotExistsException;
import com.spring.desafio.exception.ProdutoQuantityNotSufficientException;
import com.spring.desafio.repository.IProdutoRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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
