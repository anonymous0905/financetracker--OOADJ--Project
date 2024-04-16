package com.example.financetracker.repository;

import com.example.financetracker.model.FinancialReport;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinancialReportRepository extends MongoRepository<FinancialReport, String> {
}
