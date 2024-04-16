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
            // If credit score does not exist for the user, create a new one with default values
            creditScore = new CreditScore();
            creditScore.setUserId(userId);
            creditScore.setScore(0); // Default score
            creditScoreRepository.save(creditScore);
        }
        return creditScore;
    }

    public void updateCreditScore(CreditScore creditScore) {
        // Calculate the credit score based on the provided CreditScore object
        double paymentHistory = creditScore.getPaymentHistory();
        double amountsOwed = creditScore.getAmountOwed();
        int lengthOfCreditHistory = creditScore.getCreditHistoryLength();
        int newCredit = creditScore.getNewCredit();
        // Credit mix score is assumed to be 10 (good mix)

        // Calculate the credit score based on the factors and weights
        double score = (paymentHistory * 0.35) +
                ((amountsOwed / 100000) * 0.3) + // Assuming $100,000 as the maximum amount considered
                ((lengthOfCreditHistory / 15.0) * 0.15) + // Assuming 15 years as the maximum length
                ((newCredit / 4.0) * 0.1) + // Assuming 4 as the maximum number of new accounts
                10; // Credit mix score

        // Scale the score to fit within the range of 300 to 850
        score = ((score / 100) * (850 - 300)) + 300;

        // Update the credit score in the provided CreditScore object
        creditScore.setScore((int) Math.round(score));

        // Save the updated credit score into the database
        creditScoreRepository.save(creditScore);
    }
}
