// package com.example.financetracker.service;

// import com.example.financetracker.model.FinancialGoal;
// import com.example.financetracker.repository.FinancialGoalRepository;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class FinancialGoalService {
//     private final FinancialGoalRepository financialGoalRepository;

//     @Autowired
//     public FinancialGoalService(FinancialGoalRepository financialGoalRepository) {
//         this.financialGoalRepository = financialGoalRepository;
//     }

//     public List<FinancialGoal> findAllFinancialGoals() {
//         return financialGoalRepository.findAll();
//     }

//     public FinancialGoal addFinancialGoal(FinancialGoal financialGoal) {
//         return financialGoalRepository.save(financialGoal);
//     }
// }


package com.example.financetracker.service;

import com.example.financetracker.model.FinancialGoal;
import com.example.financetracker.repository.FinancialGoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinancialGoalService {
    private final FinancialGoalRepository financialGoalRepository;

    @Autowired
    public FinancialGoalService(FinancialGoalRepository financialGoalRepository) {
        this.financialGoalRepository = financialGoalRepository;
    }

    public List<FinancialGoal> findAllFinancialGoals() {
        return financialGoalRepository.findAll();
    }

    public FinancialGoal addFinancialGoal(FinancialGoal financialGoal) {
        return financialGoalRepository.save(financialGoal);
    }
}
