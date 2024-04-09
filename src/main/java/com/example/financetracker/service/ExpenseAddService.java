package com.example.financetracker.service;

import com.example.financetracker.model.ExpenseAdd;
import com.example.financetracker.repository.ExpnenseAddRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseAddService {
    private final ExpnenseAddRepository expenseaddRepository;

    @Autowired
    public ExpenseAddService(ExpnenseAddRepository expenseaddRepository) {
        this.expenseaddRepository = expenseaddRepository;
    }

    public List<ExpenseAdd> findAllExpense() {
        return expenseaddRepository.findAll();
    }

    public ExpenseAdd addExpense(ExpenseAdd expense) {
        return expenseaddRepository.save(expense);
    }
}
