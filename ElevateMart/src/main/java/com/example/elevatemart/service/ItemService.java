package com.example.elevatemart.service;

import com.example.elevatemart.dto.request.ItemRequestDto;
import com.example.elevatemart.exception.CustomerNotFoundException;
import com.example.elevatemart.exception.InsufficientQuantityException;
import com.example.elevatemart.exception.ProductNotFoundException;
import com.example.elevatemart.model.Customer;
import com.example.elevatemart.model.Item;
import com.example.elevatemart.model.Product;
import com.example.elevatemart.repository.CustomerRepository;
import com.example.elevatemart.repository.ProductRepository;
import com.example.elevatemart.transformer.ItemTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ProductRepository productRepository;
    public Item createItem(ItemRequestDto itemRequestDto) {

        Customer customer = customerRepository.findByEmailId(itemRequestDto.getCustomerEmail());
        if(customer==null){
            throw new CustomerNotFoundException("Customer doesn't exisit");
        }

        Optional<Product> productOptional = productRepository.findById(itemRequestDto.getProductId());
        if(productOptional.isEmpty()){
            throw new ProductNotFoundException("Product doesn't exist");
        }

        Product product = productOptional.get();

        // check for required quantity
        if(product.getAvailableQuantity()< itemRequestDto.getRequiredQuantity()){
            throw new InsufficientQuantityException("Sorry! Required quantity not avaiable");
        }

        // create item
        Item item = ItemTransformer.ItemRequestDtoToItem(itemRequestDto.getRequiredQuantity());
        return item;
    }
}
