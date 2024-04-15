package com.example.financetracker.service;

import com.example.financetracker.model.Budget;
import com.example.financetracker.repository.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BudgetService {
    private final BudgetRepository budgetRepository;

    @Autowired
    public BudgetService(BudgetRepository budgetRepository) {
        this.budgetRepository = budgetRepository;
    }

    public List<Budget> findAllBudgets() {
        return budgetRepository.findAll();
    }

    public Budget addBudget(Budget budget) {
        return budgetRepository.save(budget);
    }
}

// package com.example.financetracker.service;

// import com.example.financetracker.model.Budget;
// import com.example.financetracker.repository.BudgetRepository;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class BudgetService {
//     private final BudgetRepository budgetRepository;

//     @Autowired
//     public BudgetService(BudgetRepository budgetRepository) {
//         this.budgetRepository = budgetRepository;
//     }

//     public List<Budget> findAllBudgets() {
//         return budgetRepository.findAll();
//     }

//     public Budget addBudget(Budget budget) {
//         return budgetRepository.save(budget);
//     }
// }
