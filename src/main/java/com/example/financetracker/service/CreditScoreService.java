package com.example.financetracker.service;

import com.example.financetracker.model.CreditScore;
import com.example.financetracker.repository.CreditScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditScoreService {

    private final CreditScoreRepository creditScoreRepository;

    @Autowired
    public CreditScoreService(CreditScoreRepository creditScoreRepository) {
        this.creditScoreRepository = creditScoreRepository;
    }

    public CreditScore getCreditScore(String userId) {
        CreditScore creditScore = creditScoreRepository.findByUserId(userId);
        if (creditScore == null) {
            // If credit score does not exist for the user, calculate and save a new one
            creditScore = calculateCreditScore(); // Calculate the credit score
            creditScore.setUserId(userId);
            creditScoreRepository.save(creditScore);
        }
        return creditScore;
    }

    private CreditScore calculateCreditScore() {
        // Let's assume some random values for each factor
        double paymentHistory = 0; // Payment history percentage
        double amountsOwed = 0; // Amounts owed
        int lengthOfCreditHistory = 0; // Length of credit history in years
        int newCredit = 0; // Number of new credit accounts
        // Credit mix score is assumed to be 10 (good mix)

        // Calculate the credit score based on the factors and weights
        double score = (paymentHistory * 0.35) +
                ((amountsOwed / 100000) * 0.3) + // Assuming $100,000 as the maximum amount considered
                ((lengthOfCreditHistory / 15.0) * 0.15) + // Assuming 15 years as the maximum length
                ((newCredit / 4.0) * 0.1) + // Assuming 4 as the maximum number of new accounts
                10; // Credit mix score

        // Scale the score to fit within the range of 300 to 850
        score = ((score / 100) * (850 - 300)) + 300;

        // Create a new CreditScore object
        CreditScore creditScore = new CreditScore();
        creditScore.setScore((int) Math.round(score)); // Set the calculated credit score

        return creditScore;
    }
}
