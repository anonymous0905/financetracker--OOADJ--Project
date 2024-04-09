package com.example.financetracker.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "budgets")
public class Budget {
    @Id
    private String id;
    private String category;
    private double amount;
    private String timeframe;

    public Budget() {
    }

    public Budget(String category, double amount, String timeframe) {
        this.category = category;
        this.amount = amount;
        this.timeframe = timeframe;
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

    public String getTimeframe() {
        return timeframe;
    }

    public void setTimeframe(String timeframe) {
        this.timeframe = timeframe;
    }

    @Override
    public String toString() {
        return "Budget{" +
                "id='" + id + '\'' +
                ", category='" + category + '\'' +
                ", amount=" + amount +
                ", timeframe='" + timeframe + '\'' +
                '}';
    }
}

// package com.example.financetracker.model;

// import org.springframework.data.annotation.Id;
// import org.springframework.data.mongodb.core.mapping.Document;

// import java.util.ArrayList;
// import java.util.List;

// @Document(collection = "budgets")
// public class Budget {
//     @Id
//     private String id;
//     private String category;
//     private double amount;
//     private String timeframe;
//     private List<Alert> alerts; // Collection of alerts associated with the budget

//     public Budget() {
//         this.alerts = new ArrayList<>();
//     }

//     public Budget(String category, double amount, String timeframe) {
//         this.category = category;
//         this.amount = amount;
//         this.timeframe = timeframe;
//         this.alerts = new ArrayList<>();
//     }

//     // Getters and setters for id, category, amount, and timeframe

//     public List<Alert> getAlerts() {
//         return alerts;
//     }

//     public void setAlerts(List<Alert> alerts) {
//         this.alerts = alerts;
//     }

//     // Helper methods to add and remove alerts
//     public void addAlert(Alert alert) {
//         this.alerts.add(alert);
//     }

//     public void removeAlert(Alert alert) {
//         this.alerts.remove(alert);
//     }
// }


