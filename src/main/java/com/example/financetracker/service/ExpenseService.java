package com.example.financetracker.service;

import com.example.financetracker.model.Expense;
import com.example.financetracker.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class ExpenseService {
    private final ExpenseRepository expenseRepository;
    private final Path rootLocation = Paths.get("uploaded-images");

    @Autowired
    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public List<Expense> findAllExpenses() {
        return expenseRepository.findAll();
    }

    public Expense addExpense(Expense expense, MultipartFile receiptImage) {
        if (receiptImage != null && !receiptImage.isEmpty()) {
            try {
                String filename = System.currentTimeMillis() + "-" + receiptImage.getOriginalFilename();

                // Create the directory if it doesn't exist
                Files.createDirectories(rootLocation);

                Files.copy(receiptImage.getInputStream(), this.rootLocation.resolve(filename));
                expense.setReceiptImage(filename);
            } catch (IOException e) {
                throw new RuntimeException("Failed to store receipt image", e);
            }
        }
        return expenseRepository.save(expense);
    }

}
