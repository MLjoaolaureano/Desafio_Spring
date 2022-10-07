package com.spring.desafio.service;

import com.spring.desafio.entity.RequestPurchase;
import com.spring.desafio.entity.TicketPurchase;
import com.spring.desafio.exception.FileNotFoundException;
import com.spring.desafio.exception.ProductNotExistsException;
import com.spring.desafio.exception.ProductQuantityNotSufficientException;

import java.util.List;

public interface IPurchaseRequestService {

    TicketPurchase createPurchaseRequest(List<RequestPurchase> requestPurchase) throws ProductNotExistsException, FileNotFoundException, ProductQuantityNotSufficientException;

}
