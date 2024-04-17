package com.example.financetracker.service;

import com.example.financetracker.model.BillReminder;
import com.example.financetracker.model.Expense;
import com.example.financetracker.model.FinancialGoal;
import com.example.financetracker.model.FinancialReport;
import com.example.financetracker.model.Income;
import com.example.financetracker.repository.BillReminderRepository;
import com.example.financetracker.repository.ExpenseRepository;
import com.example.financetracker.repository.FinancialReportRepository;
import com.example.financetracker.repository.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@Service
public class FinancialReportService {

    private final ExpenseRepository expenseRepository;
    private final IncomeRepository incomeRepository;
    private final BillReminderRepository billReminderRepository;
    private final FinancialReportRepository financialReportRepository;
    private final FinancialGoalService financialGoalService;

    @Autowired
    public FinancialReportService(ExpenseRepository expenseRepository, IncomeRepository incomeRepository,
                                  BillReminderRepository billReminderRepository,
                                  FinancialReportRepository financialReportRepository,
                                  FinancialGoalService financialGoalService) {
        this.expenseRepository = expenseRepository;
        this.incomeRepository = incomeRepository;
        this.billReminderRepository = billReminderRepository;
        this.financialReportRepository = financialReportRepository;
        this.financialGoalService = financialGoalService;
    }

    public FinancialReport generateFinancialReport() {
        List<Expense> expenses = expenseRepository.findAll();
        List<Income> incomes = incomeRepository.findAll();
        List<BillReminder> billReminders = billReminderRepository.findAll();
        List<FinancialGoal> financialGoals = financialGoalService.findAllFinancialGoals();

        double totalExpenses = calculateTotalExpenses(expenses);
        double totalIncome = calculateTotalIncome(incomes);
        double netIncome = totalIncome - totalExpenses;
        boolean areBillsRemaining = checkRemainingBills(billReminders);
        boolean areFinancialGoalsPresent = !financialGoals.isEmpty();

        FinancialReport report = new FinancialReport();
        report.setTitle("Financial Summary");
        report.setDescription("This report summarizes the financial data for the current period.");
        report.setTotalExpenses(totalExpenses);
        report.setTotalIncome(totalIncome);
        report.setNetIncome(netIncome);
        report.setBillsRemaining(areBillsRemaining);
        report.setFinancialGoalsPresent(areFinancialGoalsPresent);

        if (areFinancialGoalsPresent) {
            double totalTargetAmount = calculateTotalTargetAmount(financialGoals);
            double totalAchievedAmount = calculateTotalAchievedAmount(financialGoals, netIncome);
            report.setTotalTargetAmount(totalTargetAmount);
            report.setTotalAchievedAmount(totalAchievedAmount);

            // Calculate and set goal completion percentage
            double goalCompletionPercentage = (totalAchievedAmount / totalTargetAmount) * 100;
            report.setGoalCompletionPercentage(goalCompletionPercentage);
        } else {
            // If no financial goals are present, set completion to 0%
            report.setGoalCompletionPercentage(0);
        }

        // Save or manipulate FinancialReport entity
        financialReportRepository.save(report);

        return report;
    }


    private double calculateTotalExpenses(List<Expense> expenses) {
        return expenses.stream()
                .mapToDouble(Expense::getAmount)
                .sum();
    }

    private double calculateTotalIncome(List<Income> incomes) {
        return incomes.stream()
                .mapToDouble(Income::getAmount)
                .sum();
    }

    private boolean checkRemainingBills(List<BillReminder> billReminders) {
        // Check if there are any remaining bills
        return !billReminders.isEmpty();
    }

    private double calculateTotalTargetAmount(List<FinancialGoal> financialGoals) {
        return financialGoals.stream()
                .mapToDouble(FinancialGoal::getTargetAmount)
                .sum();
    }

    private double calculateTotalAchievedAmount(List<FinancialGoal> financialGoals, double netIncome) {
        double totalAchievedAmount = netIncome;
        LocalDate currentDate = LocalDate.now();

        for (FinancialGoal goal : financialGoals) {
            LocalDate deadline = goal.getDeadline().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            if (deadline != null && !deadline.isAfter(currentDate)) {
                // Deadline has passed, add the target amount to the total achieved amount
                totalAchievedAmount += goal.getTargetAmount();
            }
        }

        return totalAchievedAmount;
    }

}
