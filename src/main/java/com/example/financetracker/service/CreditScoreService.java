package com.example.financetracker.service;

import com.example.financetracker.model.CreditScore;
import com.example.financetracker.repository.CreditScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditScoreService {

    private final CreditScoreRepository creditScoreRepository;

    @Autowired
    public CreditScoreService(CreditScoreRepository creditScoreRepository) {
        this.creditScoreRepository = creditScoreRepository;
    }

    public CreditScore getCreditScore(String userId) {
        return creditScoreRepository.findByUserId(userId);
    }
}
