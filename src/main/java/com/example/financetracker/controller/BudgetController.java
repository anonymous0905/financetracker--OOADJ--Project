package com.example.financetracker.controller;

import com.example.financetracker.model.Budget;
import com.example.financetracker.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/budget")
public class BudgetController {
    private final BudgetService budgetService;

    @Autowired
    public BudgetController(BudgetService budgetService) {
        this.budgetService = budgetService;
    }

    @GetMapping
    public String showBudgetPage(Model model) {
        model.addAttribute("budgets", budgetService.findAllBudgets());
        return "budget";
    }

    @PostMapping("/add")
    public String addBudget(Budget budget) {
        budgetService.addBudget(budget);
        return "redirect:/budget";
    }
}


// package com.example.financetracker.controller;

// import com.example.financetracker.model.Alert;
// import com.example.financetracker.model.Budget;
// import com.example.financetracker.service.AlertService;
// import com.example.financetracker.service.BudgetService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestMapping;

// import java.util.List;

// @Controller
// @RequestMapping("/budget")
// public class BudgetController {
//     private final BudgetService budgetService;
//     private final AlertService alertService;

//     @Autowired
//     public BudgetController(BudgetService budgetService, AlertService alertService) {
//         this.budgetService = budgetService;
//         this.alertService = alertService;
//     }

//     @GetMapping
//     public String showBudgetPage(Model model) {
//         List<Budget> budgets = budgetService.findAllBudgets();
//         List<Alert> alerts = alertService.findAlertsForBudgets(budgets);

//         model.addAttribute("budgets", budgets);
//         model.addAttribute("alerts", alerts);
//         return "budget";
//     }

//     @PostMapping("/add")
//     public String addBudget(Budget budget) {
//         budgetService.addBudget(budget);
//         return "redirect:/budget";
//     }
// }

