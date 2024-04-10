package com.example.financetracker.repository;

import com.example.financetracker.model.BillReminder;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillReminderRepository extends MongoRepository<BillReminder, String> {
}
