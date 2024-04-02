package com.example.financetracker.controller;

import com.example.financetracker.model.Expense;
import com.example.financetracker.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Controller
@RequestMapping("/expenses")
public class ExpenseController {
    private final ExpenseService expenseService;

    @Autowired
    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping
    public String showExpensePage(Model model) {
        model.addAttribute("expenses", expenseService.findAllExpenses());
        return "expenses";
    }

    @PostMapping("/add")
    public String addExpense(
            @RequestParam("category") String category,
            @RequestParam("amount") double amount,
            @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
            @RequestParam("receiptImage") MultipartFile receiptImage) {
        Expense expense = new Expense(category, amount, date, null);
        expenseService.addExpense(expense, receiptImage);
        return "redirect:/expenses";
    }
}
