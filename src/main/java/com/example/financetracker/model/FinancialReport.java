package com.example.financetracker.model;

public class FinancialReport {

    private String title;
    private String description;
    private double totalExpenses;
    private double totalIncome;
    private double netIncome;
    private boolean financialGoalMet;
    private boolean billsRemaining;
    private boolean financialGoalsPresent;
    private double totalTargetAmount;
    private double totalAchievedAmount;
    private double goalCompletionPercentage;

    // Constructors, getters, and setters

    public FinancialReport() {
    }

    public FinancialReport(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getTotalExpenses() {
        return totalExpenses;
    }

    public void setTotalExpenses(double totalExpenses) {
        this.totalExpenses = totalExpenses;
    }

    public double getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(double totalIncome) {
        this.totalIncome = totalIncome;
    }

    public double getNetIncome() {
        return netIncome;
    }

    public void setNetIncome(double netIncome) {
        this.netIncome = netIncome;
    }

    public boolean isFinancialGoalMet() {
        return financialGoalMet;
    }

    public void setFinancialGoalMet(boolean financialGoalMet) {
        this.financialGoalMet = financialGoalMet;
    }

    public boolean isBillsRemaining() {
        return billsRemaining;
    }

    public void setBillsRemaining(boolean billsRemaining) {
        this.billsRemaining = billsRemaining;
    }
    public boolean isFinancialGoalsPresent() {
        return financialGoalsPresent;
    }

    public void setFinancialGoalsPresent(boolean financialGoalsPresent) {
        this.financialGoalsPresent = financialGoalsPresent;
    }

    public double getTotalTargetAmount() {
        return totalTargetAmount;
    }

    public void setTotalTargetAmount(double totalTargetAmount) {
        this.totalTargetAmount = totalTargetAmount;
    }

    public double getTotalAchievedAmount() {
        return totalAchievedAmount;
    }

    public void setTotalAchievedAmount(double totalAchievedAmount) {
        this.totalAchievedAmount = totalAchievedAmount;
    }

    public double getGoalCompletionPercentage() {
        return goalCompletionPercentage;
    }

    public void setGoalCompletionPercentage(double goalCompletionPercentage) {
        this.goalCompletionPercentage = goalCompletionPercentage;
    }
}
