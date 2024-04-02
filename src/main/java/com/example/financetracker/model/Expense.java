package com.example.financetracker.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Document(collection = "expenses")
public class Expense {
    @Id
    private String id;
    private String category;
    private double amount;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private String receiptImage; // Store the filename or URL of the uploaded image

    public Expense() {
    }

    public Expense(String category, double amount, Date date, String receiptImage) {
        this.category = category;
        this.amount = amount;
        this.date = date;
        this.receiptImage = receiptImage;
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

    public String getReceiptImage() {
        return receiptImage;
    }

    public void setReceiptImage(String receiptImage) {
        this.receiptImage = receiptImage;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id='" + id + '\'' +
                ", category='" + category + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                ", receiptImage='" + receiptImage + '\'' +
                '}';
    }
}
