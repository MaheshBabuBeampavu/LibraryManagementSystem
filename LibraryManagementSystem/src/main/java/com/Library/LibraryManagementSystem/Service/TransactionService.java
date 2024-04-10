package com.Library.LibraryManagementSystem.Service;

import com.Library.LibraryManagementSystem.Entity.NewTransaction;
import com.Library.LibraryManagementSystem.Entity.Transactions;

import java.util.UUID;

public interface TransactionService {
    Object transaction(NewTransaction transactions5);

    Object getTransactionById(String id);

    Object getTransactions();
}
