package com.example.financetracker.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;


@Document(collection = "incomes")
public class Income {
    @Id
    private String id;
    private String source;
    private double amount;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    public Income() {
    }

    public Income(String source, double amount, Date date) {
        this.source = source;
        this.amount = amount;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
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
        return "Income{" +
                "id='" + id + '\'' +
                ", source='" + source + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }
}
