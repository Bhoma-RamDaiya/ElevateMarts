package com.example.elevatemart.service;

import com.example.elevatemart.dto.request.CustomerRequestDto;
import com.example.elevatemart.dto.response.CustomerResponseDto;
import com.example.elevatemart.model.Cart;
import com.example.elevatemart.model.Customer;
import com.example.elevatemart.repository.CustomerRepository;
import com.example.elevatemart.transformer.CustomerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public CustomerResponseDto addCustomer(CustomerRequestDto customerRequestDto) {

        // dto -> entity
        Customer customer = CustomerTransformer.CustomerRequestDtoToCustomer(customerRequestDto);

        Cart cart = new Cart();
        cart.setCartTotal(0);
        cart.setCustomer(customer);
        customer.setCart(cart);

        Customer savedCustomer = customerRepository.save(customer);   // saves both customer and cart;

        // prepare the response dto
        return CustomerTransformer.CustomerToCustomerResponseDto(savedCustomer);

    }
}
