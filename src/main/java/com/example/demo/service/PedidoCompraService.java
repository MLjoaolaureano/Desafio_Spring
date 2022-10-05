package com.example.demo.service;

import com.example.demo.entity.PedidoCompra;
import com.example.demo.entity.Produto;
import com.example.demo.entity.TicketCompra;
import com.example.demo.exception.FileNotFoundException;
import com.example.demo.exception.ProdutoNotExistsException;
import com.example.demo.repository.IProdutoRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoCompraService implements IPedidoCompraService{

    private final IProdutoRepository produtoRepository;

    public PedidoCompraService(IProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }


    @Override
    public TicketCompra createPedidoCompra(List<PedidoCompra> pedidoCompraList) throws ProdutoNotExistsException, FileNotFoundException {
        List<Produto> produtoList = new ArrayList<>();
        BigDecimal totalValor = BigDecimal.valueOf(0.0);


        for(PedidoCompra compra: pedidoCompraList){
            Produto produto = this.produtoRepository.getProdutoById(compra.getProductId());
            produtoList.add(produto);
            totalValor = totalValor.add(produto.getPrice());
        }
        TicketCompra novoTicket = new TicketCompra(produtoList, totalValor);

        return novoTicket;
    }
}
