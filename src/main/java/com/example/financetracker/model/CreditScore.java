package com.example.financetracker.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "credit_scores")
public class CreditScore {

    @Id
    private String id;
    private int score;
    private String userId;

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

    @Override
    public String toString() {
        return "CreditScore{" +
                "id='" + id + '\'' +
                ", score=" + score +
                ", userId='" + userId + '\'' +
                '}';
    }
}
