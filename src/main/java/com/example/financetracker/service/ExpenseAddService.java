package com.example.financetracker.service;

import com.example.financetracker.model.ExpenseAdd;
import com.example.financetracker.repository.ExpenseAddRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseAddService {
    private final ExpenseAddRepository expenseRepository;

    @Autowired
    public ExpenseAddService(ExpenseAddRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public List<ExpenseAdd> findAllExpenses() {
        return expenseRepository.findAll();
    }

    public ExpenseAdd addExpense(ExpenseAdd expense) {
        return expenseRepository.save(expense);
    }
}
