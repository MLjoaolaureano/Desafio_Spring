package com.spring.desafio.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.spring.desafio.entity.RequestPurchase;
import com.spring.desafio.entity.Product;
import com.spring.desafio.exception.ExistentProductIdException;
import com.spring.desafio.exception.FileNotFoundException;
import com.spring.desafio.exception.ProductNotExistsException;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Repository for {@link Product}
 */
@Repository
public class ProductRepository implements IProductRepository {
    private final String linkFile = "src/main/resources/products.json";
    ObjectMapper mapper = new ObjectMapper();
    ObjectWriter writer = mapper.writer();

    /**
     * Fetch the JSON file for storage and returns all products
     *
     * @return list of products
     * @throws FileNotFoundException in case the filename is incorrect, or file does not exist
     */
    public List<Product> getAll() throws FileNotFoundException {

        File storeFile = new File(linkFile);
        List<Product> products = null;
        try {
            products = Arrays.asList(mapper.readValue(storeFile, Product[].class));
        } catch (IOException e) {
            throw new FileNotFoundException("Arquivo não encontrado.");
        }
        return products;
    }

    /**
     * Stores a list of {@link Product} and returns it.
     *
     * @param productList list of {@link Product} to be stored
     * @return list of products stored
     * @throws ExistentProductIdException in case the productId already exist in storage
     * @throws FileNotFoundException      in case the filename is incorrect, or file does not exist
     */
    public List<Product> saveAll(List<Product> productList) throws ExistentProductIdException, FileNotFoundException {
        List<Product> copylist;
        try {
            List<Product> actualList = Arrays.asList(mapper.readValue(new File(linkFile), Product[].class));
            List<Long> existentIds = new ArrayList<>();
            for (Product product : productList) {
                if (actualList.stream().map(Product::getProductId).toList().contains(product.getProductId())) {
                    existentIds.add(product.getProductId());
                }
            }
            if (!existentIds.isEmpty()) {
                throw new ExistentProductIdException("Não foi possível inserir os produtos. Ids já existentes: " + existentIds);
            }

            copylist = new ArrayList<>(actualList);
            copylist.addAll(productList);
            writer.writeValue(new File(linkFile), copylist);
        } catch (IOException e) {
            throw new FileNotFoundException("Arquivo não encontrado.");
        } catch (ExistentProductIdException e) {
            throw new ExistentProductIdException(e.getMessage());
        }

        return productList;
    }

    /**
     * Returns a product based in its productId
     *
     * @param id productId to be fetched
     * @return a product entity
     * @throws FileNotFoundException
     * @throws ProductNotExistsException in case {@link Product} does not exists
     */
    public Product getProductById(Long id) throws FileNotFoundException, ProductNotExistsException {
        File storeFile = new File(linkFile);
        List<Product> products = null;
        try {
            products = Arrays.asList(mapper.readValue(storeFile, Product[].class));
        } catch (IOException e) {
            throw new FileNotFoundException("Arquivo não encontrado");
        }
        Optional<Product> optionalProduct = products.stream().filter((p) -> p.getProductId().equals(id)).findFirst();
        if (optionalProduct.isEmpty()) {
            throw new ProductNotExistsException("Produto " + id + " não existe");
        } else {
            return optionalProduct.get();
        }
    }

    /**
     * Update quantity of items of {@link Product}
     * @param requestPurchaseList list of {@link RequestPurchase}
     * @throws FileNotFoundException in case the filename is incorrect, or file does not exist
     */
    public void updateStorage(List<RequestPurchase> requestPurchaseList) throws FileNotFoundException {
        try {
            List<Product> actualList = Arrays.asList(mapper.readValue(new File(linkFile), Product[].class));
            List<Product> newList = new ArrayList<>(actualList);

            actualList.stream().forEach(item -> {
                for (int i = 0; i < requestPurchaseList.size(); i++) {
                    if (item.getProductId() == requestPurchaseList.get(i).getProductId()){
                        newList.get(i).setQuantity(item.getQuantity() - requestPurchaseList.get(i).getQuantity());
                    }
                }
            });
            writer.writeValue(new File(linkFile), newList);
        } catch (IOException e) {
            throw new FileNotFoundException("Arquivo não encontrado.");
        }
    }

}
