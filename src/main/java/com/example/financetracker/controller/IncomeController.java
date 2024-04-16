package com.example.financetracker.controller;

import com.example.financetracker.model.Income;
import com.example.financetracker.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

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
    public String addIncome(@RequestParam String source, @RequestParam double amount, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        Income income = Income.builder()
                .source(source)
                .amount(amount)
                .date(date)
                .build();
        incomeService.addIncome(income);
        return "redirect:/income";
    }
}
