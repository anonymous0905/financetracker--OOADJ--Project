package com.example.financetracker.repository;

import com.example.financetracker.model.CreditScore;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CreditScoreRepository extends MongoRepository<CreditScore, String> {
    CreditScore findByUserId(String userId);
}
