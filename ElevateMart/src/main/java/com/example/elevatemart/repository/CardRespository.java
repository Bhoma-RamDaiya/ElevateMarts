package com.example.elevatemart.repository;

import com.example.elevatemart.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRespository extends JpaRepository<Card,Integer> {

    public Card findByCardNo(String cardNo);
}
