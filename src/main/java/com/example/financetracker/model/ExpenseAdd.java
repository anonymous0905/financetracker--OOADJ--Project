package com.example.financetracker.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Document(collection = "expenses")
public class ExpenseAdd {
    @Id
    private String id;
    private String category;
    private double amount;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    private ExpenseAdd() {}

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String category;
        private double amount;
        private Date date;

        public Builder category(String category) {
            this.category = category;
            return this;
        }

        public Builder amount(double amount) {
            this.amount = amount;
            return this;
        }

        public Builder date(Date date) {
            this.date = date;
            return this;
        }

        public ExpenseAdd build() {
            ExpenseAdd expenseAdd = new ExpenseAdd();
            expenseAdd.category = this.category;
            expenseAdd.amount = this.amount;
            expenseAdd.date = this.date;
            return expenseAdd;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ExpenseAdd{" +
                "id='" + id + '\'' +
                ", category='" + category + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }
}
