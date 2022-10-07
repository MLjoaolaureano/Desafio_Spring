package com.spring.desafio.service;

import com.spring.desafio.entity.Product;
import com.spring.desafio.entity.RequestPurchase;
import com.spring.desafio.entity.TicketPurchase;
import com.spring.desafio.exception.FileNotFoundException;
import com.spring.desafio.exception.ProductNotExistsException;
import com.spring.desafio.exception.ProductQuantityNotSufficientException;
import com.spring.desafio.repository.IProductRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * ProdutoService is the Service bean for {@link RequestPurchase} entity.
 */
@Service
public class PurchaseRequestService implements IPurchaseRequestService {

    private final IProductRepository productRepository;

    public PurchaseRequestService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * Performs a purchase and returns a {@link TicketPurchase}
     *
     * @param requestPurchaseList list of {@link RequestPurchase} for the purchase request.
     * @return a ticket for the purchase request
     * @throws ProductNotExistsException             in case the product does not exist in storage
     * @throws FileNotFoundException
     * @throws ProductQuantityNotSufficientException in case product quantity does not exist in storage
     */
    @Override
    public TicketPurchase createPurchaseRequest(List<RequestPurchase> requestPurchaseList) throws ProductNotExistsException, FileNotFoundException, ProductQuantityNotSufficientException {
        Set<Product> productSet = new HashSet<>();
        BigDecimal finalValue = BigDecimal.valueOf(0.0);
        List<Product> productList = this.productRepository.getAll();
        for (RequestPurchase requestPurchase : requestPurchaseList) {
            Product product = productList.stream()
                    .filter(p -> p.getProductId().equals(requestPurchase.getProductId()))
                    .toList().get(0);

            if (product.getQuantity() < requestPurchase.getQuantity()) {
                throw new ProductQuantityNotSufficientException("Estoque de produto é insuficiente");
            } else {
                product.setQuantity(product.getQuantity() - requestPurchase.getQuantity());
                productSet.add(product);
                finalValue = finalValue.add(product.getPrice().multiply(BigDecimal.valueOf(requestPurchase.getQuantity())));
            }
        }

        productSet.stream().forEach(p -> {
            for (int i = 0; i < requestPurchaseList.size(); i++){
                if (p.getProductId() == requestPurchaseList.get(i).getProductId())
                    p.setQuantity(requestPurchaseList.get(i).getQuantity());
            }
        });

        productRepository.updateStorage(requestPurchaseList);

        TicketPurchase newTicket = new TicketPurchase(productSet.stream().toList(), finalValue);

        return newTicket;
    }
}
