package com.example.financetracker.controller;

import com.example.financetracker.model.Income;
import com.example.financetracker.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/income")
public class IncomeController {
    private final IncomeService incomeService;

    @Autowired
    public IncomeController(IncomeService incomeService) {
        this.incomeService = incomeService;
    }

    @GetMapping
    public String showIncomePage(Model model) {
        model.addAttribute("incomes", incomeService.findAllIncomes());
        return "income";
    }

    @PostMapping("/add")
    public String addIncome(Income income) {
        incomeService.addIncome(income);
        return "redirect:/income";
    }
}
