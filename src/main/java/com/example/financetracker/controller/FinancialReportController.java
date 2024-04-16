package com.example.financetracker.controller;

import com.example.financetracker.model.FinancialReport;
import com.example.financetracker.facade.FinancialReportFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/financialReports")
public class FinancialReportController {

    private final FinancialReportFacade financialReportFacade;

    @Autowired
    public FinancialReportController(FinancialReportFacade financialReportFacade) {
        this.financialReportFacade = financialReportFacade;
    }

    @GetMapping
    public String showFinancialReports(Model model) {
        FinancialReport report = financialReportFacade.generateFinancialReport();
        model.addAttribute("report", report);
        return "FinancialReport";
    }
}
