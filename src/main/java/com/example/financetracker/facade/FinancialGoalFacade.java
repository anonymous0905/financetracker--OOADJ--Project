package com.example.financetracker.facade;

import com.example.financetracker.model.FinancialGoal;
import com.example.financetracker.service.FinancialGoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FinancialGoalFacade {
    private final FinancialGoalService financialGoalService;

    @Autowired
    public FinancialGoalFacade(FinancialGoalService financialGoalService) {
        this.financialGoalService = financialGoalService;
    }

    public List<FinancialGoal> findAllFinancialGoals() {
        return financialGoalService.findAllFinancialGoals();
    }

    public FinancialGoal addFinancialGoal(FinancialGoal financialGoal) {
        return financialGoalService.addFinancialGoal(financialGoal);
    }
}
