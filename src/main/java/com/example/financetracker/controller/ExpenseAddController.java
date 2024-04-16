package com.example.financetracker.controller;

import com.example.financetracker.model.ExpenseAdd;
import com.example.financetracker.service.ExpenseAddService;
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
@RequestMapping("/expenseadd")
public class ExpenseAddController {
    private final ExpenseAddService expenseService;

    @Autowired
    public ExpenseAddController(ExpenseAddService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping
    public String showExpenseAddPage(Model model) {
        model.addAttribute("expenses", expenseService.findAllExpenses());
        return "expenseadd";
    }

    @PostMapping("/add")
    public String addExpense(@RequestParam String category, @RequestParam double amount, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        ExpenseAdd expense = ExpenseAdd.builder()
                .category(category)
                .amount(amount)
                .date(date)
                .build();
        expenseService.addExpense(expense);
        return "redirect:/expenseadd";
    }
}
