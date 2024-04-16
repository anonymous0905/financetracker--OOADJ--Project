package com.example.financetracker.controller;

import com.example.financetracker.model.CreditScore;
import com.example.financetracker.service.CreditScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/creditScore")
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
}
