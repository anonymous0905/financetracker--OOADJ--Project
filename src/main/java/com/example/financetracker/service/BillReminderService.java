package com.example.financetracker.service;

import com.example.financetracker.model.BillReminder;
import com.example.financetracker.repository.BillReminderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillReminderService {
    @Autowired
    private BillReminderRepository billReminderRepository;

    public List<BillReminder> getAllReminders() {
        return billReminderRepository.findAll();
    }

    public void addReminder(BillReminder reminder) {
        billReminderRepository.save(reminder);
    }

    public Optional<BillReminder> getReminderById(String id) {
        return billReminderRepository.findById(id);
    }

    

    public void deleteReminder(String id) {
        billReminderRepository.deleteById(id);
    }

    public void markAsPaid(String id) {
        Optional<BillReminder> reminderOptional = billReminderRepository.findById(id);
        if (reminderOptional.isPresent()) {
            BillReminder reminder = reminderOptional.get();
            reminder.setPaid(true);
            billReminderRepository.save(reminder);
        }
    }
}
