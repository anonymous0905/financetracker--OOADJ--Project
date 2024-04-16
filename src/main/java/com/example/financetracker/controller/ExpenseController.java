package com.example.financetracker.controller;

import com.example.financetracker.model.Expense;
import com.example.financetracker.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

@Controller
@RequestMapping("/expenses")
public class ExpenseController {
    private final ExpenseService expenseService;
    private final Path rootLocation = Paths.get("uploaded-images");

    @Autowired
    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping
    public String showExpensePage(Model model) {
        model.addAttribute("expenses", expenseService.findAllExpenses());
        return "expenses";
    }

    @PostMapping("/add")
    public String addExpense(@RequestParam("category") String category,
                             @RequestParam("amount") double amount,
                             @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
                             @RequestParam("receiptImage") MultipartFile receiptImage,
                             Model model) {
        try {
            String filename = System.currentTimeMillis() + "-" + receiptImage.getOriginalFilename();
            Files.copy(receiptImage.getInputStream(), this.rootLocation.resolve(filename));
            Expense expense = new Expense(category, amount, date, filename);
            expenseService.addExpense(expense,receiptImage);
            return "redirect:/expenses";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Error: " + e.getMessage());
            return "expenses";
        }
    }

    @GetMapping("/image/{filename:.+}")
    public ResponseEntity<?> serveFile(@PathVariable String filename) {
        try {
            Path file = rootLocation.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                String mimeType = Files.probeContentType(file);
                if (mimeType == null) {
                    mimeType = "application/octet-stream"; // Default MIME type if detection fails
                }
                return ResponseEntity.ok()
                        .contentType(MediaType.parseMediaType(mimeType))
                        .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + resource.getFilename() + "\"")
                        .body(resource);
            } else {
                throw new RuntimeException("Could not read file: " + filename);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to load image " + filename + " due to: " + e.getMessage());
        }
    }
}
