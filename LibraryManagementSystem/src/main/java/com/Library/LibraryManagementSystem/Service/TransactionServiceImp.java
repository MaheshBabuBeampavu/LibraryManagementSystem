package com.Library.LibraryManagementSystem.Service;

import com.Library.LibraryManagementSystem.Entity.Books;
import com.Library.LibraryManagementSystem.Entity.Members;
import com.Library.LibraryManagementSystem.Entity.NewTransaction;
import com.Library.LibraryManagementSystem.Entity.Transactions;
import com.Library.LibraryManagementSystem.Repository.BooksRepository;
import com.Library.LibraryManagementSystem.Repository.MembersRepository;
import com.Library.LibraryManagementSystem.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;

@Service
public class TransactionServiceImp implements TransactionService{
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    BooksRepository booksRepository;
    @Autowired
    MembersRepository membersRepository;
    @Override
    public Object transaction(NewTransaction transactions) {

        if(transactions.getType().equals("return")){
            Transactions transactions1=new Transactions();
            transactions1.setTransactionType(transactions.getType());
            Date date=new Date();
            Date date1=new Date(2024,4,2);
            transactions1.setDueDate(date1.toString());
            transactions1.setReturnDate(date.toString());



           long bookId=transactions.getBookId();
           Optional<Books> books=booksRepository.findById(bookId);
           if(books.isPresent()) {
               Books books1=books.get();
               books1.setQuantity(books1.getQuantity()+1);
               Books books2 = booksRepository.save(books1);
               transactions1.setBooks(books2);

               long memberId=transactions.getMemberId();
               transactions1.setMembers(membersRepository.findById(memberId).get());


               transactionRepository.save(transactions1);
           }
        }
        else{
            Transactions transactions1=new Transactions();
            transactions1.setTransactionType(transactions.getType());
            Date date=new Date();
            Date date1=new Date(2024,10,2);
            transactions1.setDueDate(date.toString());
            transactions1.setReturnDate(date1.toString());



            long bookId=transactions.getBookId();
            Optional<Books> books=booksRepository.findById(bookId);
            if(books.isPresent()) {
                Books books1 = books.get();
                books1.setQuantity(books1.getQuantity() - 1);
                Books books2 = booksRepository.save(books1);
                transactions1.setBooks(books2);

                long memberId = transactions.getMemberId();
                transactions1.setMembers(membersRepository.findById(memberId).get());


                transactionRepository.save(transactions1);
            }

        }
        return "success";
    }

    @Override
    public Object getTransactionById(long id) {
        return transactionRepository.findById(id);
    }

    @Override
    public Object getTransactions() {
        return transactionRepository.findAll();
    }


}
