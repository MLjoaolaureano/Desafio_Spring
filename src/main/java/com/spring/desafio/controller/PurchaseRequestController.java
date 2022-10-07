package com.spring.desafio.controller;


import com.spring.desafio.entity.RequestPurchase;
import com.spring.desafio.entity.TicketPurchase;
import com.spring.desafio.exception.DuplicatadeProductIdException;
import com.spring.desafio.exception.FileNotFoundException;
import com.spring.desafio.exception.ProductNotExistsException;
import com.spring.desafio.exception.ProductQuantityNotSufficientException;
import com.spring.desafio.service.IPurchaseRequestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Main controller for {@link RequestPurchase} entity
 */
@RestController
@RequestMapping("api/v1/purchase-request")
public class PurchaseRequestController {

    IPurchaseRequestService purchaseRequestService;

    PurchaseRequestController(IPurchaseRequestService purchaseRequestService) {
        this.purchaseRequestService = purchaseRequestService;
    }

    /**
     * POST endpoint to receive {@link List< RequestPurchase >} payload from user and returns the ticket created for purchase request
     *
     * @param payload
     * @return the ticket created for the purchase request
     * @throws ProductNotExistsException             in case the product does not exist in storage
     * @throws FileNotFoundException
     * @throws ProductQuantityNotSufficientException in case the product quantity is not enough in storage
     */
    @PostMapping
    public ResponseEntity<TicketPurchase> purchaseRequest(@RequestBody List<RequestPurchase> payload) throws ProductNotExistsException, FileNotFoundException, ProductQuantityNotSufficientException, DuplicatadeProductIdException {
        List<Long> productId = new ArrayList<>();

        for (RequestPurchase requestPurchase : payload) {
            if (productId.contains(requestPurchase.getProductId())) {
                throw new DuplicatadeProductIdException("O produto com id " + requestPurchase.getProductId() + " está duplicado.");
            } else {
                productId.add(requestPurchase.getProductId());
            }
        }

        TicketPurchase ticket = this.purchaseRequestService.createPurchaseRequest(payload);
        return ResponseEntity.ok(ticket);
    }
}
