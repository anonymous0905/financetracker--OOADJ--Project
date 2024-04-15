package com.example.financetracker.controller;

import com.example.financetracker.model.FinancialGoal;
import com.example.financetracker.service.FinancialGoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/financial_goal")
public class FinancialGoalController {
    private final FinancialGoalService financialGoalService;

    @Autowired
    public FinancialGoalController(FinancialGoalService financialGoalService) {
        this.financialGoalService = financialGoalService;
    }

    @GetMapping
    public String showFinancialGoalPage(Model model) {
        model.addAttribute("financialGoal", new FinancialGoal()); // Add an empty FinancialGoal object to the model
        model.addAttribute("financialGoals", financialGoalService.findAllFinancialGoals());
        return "financial_goal";
    }

    @PostMapping("/add")
    public String addFinancialGoal(FinancialGoal financialGoal, Model model) {
        financialGoalService.addFinancialGoal(financialGoal);
        // Add an empty FinancialGoal object to the model for the form
        model.addAttribute("financialGoal", new FinancialGoal());
        model.addAttribute("financialGoals", financialGoalService.findAllFinancialGoals());
        return "redirect:/financial_goal";
    }
}
