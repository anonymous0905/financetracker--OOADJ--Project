package com.example.financetracker.controller;

import com.example.financetracker.model.ExpenseAdd;
import com.example.financetracker.service.ExpenseAddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/expenseadd")
public class ExpenseAddController {
    private final ExpenseAddService expenseService;

    @Autowired
    public ExpenseAddController(ExpenseAddService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping
    public String showIncomePage(Model model) {
        model.addAttribute("expenses", expenseService.findAllExpenses());
        return "expenseadd";
    }

    @PostMapping("/add")
    public String addIncome(ExpenseAdd expense) {
        expenseService.addExpense(expense);
        return "redirect:/expenseadd";
    }
}
