package com.Library.LibraryManagementSystem.Controller;

import com.Library.LibraryManagementSystem.Entity.NewTransaction;
import com.Library.LibraryManagementSystem.Entity.Transactions;
import com.Library.LibraryManagementSystem.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")

public class TransactionController {
    @Autowired
    TransactionService transactionService;
    @PostMapping("/create")
    public Object transaction(@RequestBody NewTransaction transaction5){
        return transactionService.transaction(transaction5);
    }
}
