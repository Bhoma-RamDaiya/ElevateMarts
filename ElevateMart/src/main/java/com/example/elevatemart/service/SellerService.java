package com.example.elevatemart.service;

import com.example.elevatemart.dto.request.SellerRequestDto;
import com.example.elevatemart.dto.response.SellerResponseDto;
import com.example.elevatemart.model.Seller;
import com.example.elevatemart.repository.SellerRepository;
import com.example.elevatemart.transformer.SellerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerService {

    @Autowired
    SellerRepository sellerRepository;

    public SellerResponseDto addSeller(SellerRequestDto sellerRequestDto) {

        // dto -> entity
        Seller seller = SellerTransformer.SellerRequestDtoToSeller(sellerRequestDto);

        // save the entity
        Seller savedSeller = sellerRepository.save(seller);

        // prepare response dto
        return SellerTransformer.SellerToSellerResponseDto(savedSeller);
    }
}
