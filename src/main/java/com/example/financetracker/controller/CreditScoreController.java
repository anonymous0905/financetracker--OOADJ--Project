package com.example.financetracker.controller;

import com.example.financetracker.model.CreditScore;
import com.example.financetracker.service.CreditScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@RequestMapping("/creditscore")
public class CreditScoreController {

    private final CreditScoreService creditScoreService;

    @Autowired
    public CreditScoreController(CreditScoreService creditScoreService) {
        this.creditScoreService = creditScoreService;
    }

    @GetMapping
    public String showCreditScore(Model model, String userId) {
        CreditScore creditScore = creditScoreService.getCreditScore(userId);
        model.addAttribute("creditScore", creditScore);
        return "creditScore";
    }

    @PostMapping("/submit")
    public String submitCreditScore(@ModelAttribute CreditScore creditScore) {
        // Update the credit score in the database using the CreditScoreService
        creditScoreService.updateCreditScore(creditScore);
        return "redirect:/creditScore?userId=" + creditScore.getUserId();
    }
}
