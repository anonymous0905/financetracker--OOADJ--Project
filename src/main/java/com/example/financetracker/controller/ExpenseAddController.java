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
@RequestMapping("/expense")
public class ExpenseAddController {
    private final ExpenseAddService expenseAddService;

    @Autowired
    public ExpenseAddController(ExpenseAddService expenseAddService) {
        this.expenseAddService = expenseAddService;
    }

    @GetMapping
    public String showExpensPage(Model model) {
        model.addAttribute("expenseadd", expenseAddService.findAllExpense());
        return "expense";
    }

    @PostMapping("/add")
    public String addExpense(ExpenseAdd expense) {
        expenseAddService.addExpense(expense);
        return "redirect:/expense";
    }
}
