package com.example.elevatemart.controller;

import com.example.elevatemart.dto.request.CheckoutCartRequestDto;
import com.example.elevatemart.dto.request.ItemRequestDto;
import com.example.elevatemart.dto.response.CartResponseDto;
import com.example.elevatemart.dto.response.OrderResponseDto;
import com.example.elevatemart.model.Item;
import com.example.elevatemart.repository.CartRepository;
import com.example.elevatemart.service.CartService;
import com.example.elevatemart.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    ItemService itemService;

    @Autowired
    CartService cartService;

    @Autowired
    CartRepository cartRepository;

    @PostMapping("/add")
    public ResponseEntity addToCart(@RequestBody ItemRequestDto itemRequestDto){

        try{
          Item item = itemService.createItem(itemRequestDto);
          CartResponseDto cartResponseDto = cartService.addItemToCart(itemRequestDto,item);
          return new ResponseEntity(cartResponseDto,HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/checkout")
    public ResponseEntity checkoutCart(@RequestBody CheckoutCartRequestDto checkoutCartRequestDto){

        try{
          OrderResponseDto response = cartService.checkoutCart(checkoutCartRequestDto);
          return new ResponseEntity(response,HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
