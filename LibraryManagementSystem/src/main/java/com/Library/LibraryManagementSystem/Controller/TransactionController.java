package com.Library.LibraryManagementSystem.Controller;

import com.Library.LibraryManagementSystem.Entity.NewTransaction;
import com.Library.LibraryManagementSystem.Entity.Transactions;
import com.Library.LibraryManagementSystem.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")

public class TransactionController {
    @Autowired
    TransactionService transactionService;
    @PostMapping("/create")
    public Object transaction(@RequestBody NewTransaction transaction5){
        return transactionService.transaction(transaction5);
    }
    @GetMapping("/{id}")
    public Object getTransactionById(@PathVariable long id){
        return transactionService.getTransactionById(id);
    }
    @GetMapping("/get")
    public Object getTransactions(){
        return transactionService.getTransactions();
    }



}
