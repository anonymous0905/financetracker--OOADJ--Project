package com.example.financetracker.controller;

import com.example.financetracker.model.FinancialGoal;
import com.example.financetracker.facade.FinancialGoalFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/financial_goal")
public class FinancialGoalController {
    private final FinancialGoalFacade financialGoalFacade;

    @Autowired
    public FinancialGoalController(FinancialGoalFacade financialGoalFacade) {
        this.financialGoalFacade = financialGoalFacade;
    }

    @GetMapping
    public String showFinancialGoalPage(Model model) {
        model.addAttribute("financialGoal", new FinancialGoal());
        model.addAttribute("financialGoals", financialGoalFacade.findAllFinancialGoals());
        return "financial_goal";
    }

    @PostMapping("/add")
    public String addFinancialGoal(FinancialGoal financialGoal, Model model) {
        financialGoalFacade.addFinancialGoal(financialGoal);
        model.addAttribute("financialGoal", new FinancialGoal());
        model.addAttribute("financialGoals", financialGoalFacade.findAllFinancialGoals());
        return "redirect:/financial_goal";
    }
}
