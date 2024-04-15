package com.example.financetracker.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Document(collection = "financial_goals")
public class FinancialGoal {
    @Id
    private String id;
    private String name;
    private double targetAmount;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date deadline;

    public FinancialGoal() {
    }

    public FinancialGoal(String name, double targetAmount, Date deadline) {
        this.name = name;
        this.targetAmount = targetAmount;
        this.deadline = deadline;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTargetAmount() {
        return targetAmount;
    }

    public void setTargetAmount(double targetAmount) {
        this.targetAmount = targetAmount;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "FinancialGoal{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", targetAmount=" + targetAmount +
                ", deadline=" + deadline +
                '}';
    }
}
