package com.example.elevatemart.repository;

import com.example.elevatemart.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller,Integer> {

    public Seller findByEmailId(String email);
}
