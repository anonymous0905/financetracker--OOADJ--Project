package com.example.financetracker.controller;

import com.example.financetracker.model.FinancialReport;
import com.example.financetracker.service.FinancialReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/financialReports")
public class FinancialReportController {

    private final FinancialReportService financialReportService;

    @Autowired
    public FinancialReportController(FinancialReportService financialReportService) {
        this.financialReportService = financialReportService;
    }

    @GetMapping
    public String showFinancialReports(Model model) {
        FinancialReport report = financialReportService.generateFinancialReport();
        model.addAttribute("report", report);
        return "FinancialReport";
    }
}