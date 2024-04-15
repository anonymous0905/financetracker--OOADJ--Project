package com.example.financetracker.service;

import com.example.financetracker.model.FinancialReport;
import com.example.financetracker.repository.FinancialReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinancialReportService {

    private final FinancialReportRepository financialReportRepository;

    @Autowired
    public FinancialReportService(FinancialReportRepository financialReportRepository) {
        this.financialReportRepository = financialReportRepository;
    }

    public List<FinancialReport> getAllFinancialReports() {
        return financialReportRepository.findAll();
    }

    // Additional methods for Financial Report management can be added here as needed
}
