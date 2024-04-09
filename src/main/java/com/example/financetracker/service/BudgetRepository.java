package com.example.financetracker.repository;

import com.example.financetracker.model.Budget;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BudgetRepository extends MongoRepository<Budget, String> {
}

