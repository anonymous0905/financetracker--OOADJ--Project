package com.example.financetracker.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "credit_scores")
public class CreditScore {

    @Id
    private String id;
    private int score;
    private String userId;
    private int paymentHistory; // Payment history (35%)
    private int amountOwed; // Amount owed (30%)
    private int creditHistoryLength; // Length of credit history (15%)
    private int newCredit; // New credit (10%)
    private int creditMix; // Credit mix (10%)

    public CreditScore() {
    }

    public CreditScore(int score, String userId) {
        this.score = score;
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getPaymentHistory() {
        return paymentHistory;
    }

    public void setPaymentHistory(int paymentHistory) {
        this.paymentHistory = paymentHistory;
    }

    public int getAmountOwed() {
        return amountOwed;
    }

    public void setAmountOwed(int amountOwed) {
        this.amountOwed = amountOwed;
    }

    public int getCreditHistoryLength() {
        return creditHistoryLength;
    }

    public void setCreditHistoryLength(int creditHistoryLength) {
        this.creditHistoryLength = creditHistoryLength;
    }

    public int getNewCredit() {
        return newCredit;
    }

    public void setNewCredit(int newCredit) {
        this.newCredit = newCredit;
    }

    public int getCreditMix() {
        return creditMix;
    }

    public void setCreditMix(int creditMix) {
        this.creditMix = creditMix;
    }

    @Override
    public String toString() {
        return "CreditScore{" +
                "id='" + id + '\'' +
                ", score=" + score +
                ", userId='" + userId + '\'' +
                ", paymentHistory=" + paymentHistory +
                ", amountOwed=" + amountOwed +
                ", creditHistoryLength=" + creditHistoryLength +
                ", newCredit=" + newCredit +
                ", creditMix=" + creditMix +
                '}';
    }
}
