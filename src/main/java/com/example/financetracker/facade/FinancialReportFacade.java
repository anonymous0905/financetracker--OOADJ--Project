package com.example.financetracker.facade;

import com.example.financetracker.model.FinancialReport;
import com.example.financetracker.service.FinancialReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FinancialReportFacade {
    private final FinancialReportService financialReportService;

    @Autowired
    public FinancialReportFacade(FinancialReportService financialReportService) {
        this.financialReportService = financialReportService;
    }

    public FinancialReport generateFinancialReport() {
        return financialReportService.generateFinancialReport();
    }
}
