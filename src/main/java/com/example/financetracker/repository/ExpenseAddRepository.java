package com.example.financetracker.repository;

import com.example.financetracker.model.ExpenseAdd;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExpenseAddRepository extends MongoRepository<ExpenseAdd, String> {
}
