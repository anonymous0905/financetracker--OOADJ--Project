package com.example.financetracker.controller;

import com.example.financetracker.model.BillReminder;
import com.example.financetracker.service.BillReminderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class BillReminderController {
    @Autowired
    private BillReminderService billReminderService;

    @GetMapping("/")
    public String index(Model model) {
        List<BillReminder> reminders = billReminderService.getAllReminders();
        model.addAttribute("reminders", reminders);
        return "index";
    }

    @PostMapping("/add")
    public String addBillReminder(@ModelAttribute("billReminder") BillReminder reminder) {
        billReminderService.addReminder(reminder);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") String id, Model model) {
        Optional<BillReminder> reminder = billReminderService.getReminderById(id);
        if (reminder.isPresent()) {
            model.addAttribute("reminder", reminder.get());
            return "edit";
        } else {
            return "redirect:/";
        }
    }

    

    @GetMapping("/delete/{id}")
    public String deleteReminder(@PathVariable("id") String id) {
        billReminderService.deleteReminder(id);
        return "redirect:/";
    }

    @GetMapping("/markPaid/{id}")
    public String markAsPaid(@PathVariable("id") String id) {
        billReminderService.markAsPaid(id);
        return "redirect:/";
    }
}
