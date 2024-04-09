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
               books1.setQuantity(books1.getQuantity()-1);
               Books books2 = booksRepository.save(books1);
               transactions1.setBooks(books2);

               long memberId=transactions.getMemberId();
               transactions1.setMembers(membersRepository.findById(memberId).get());


               //transactions1.se
               //transactions1.setMembers();
               transactionRepository.save(transactions1);
           }
        }
        else{
//            Transactions transactions2=new Transactions();
//            transactions2.setTransactionType(transactions.getType());
//            transactions2.setDueDate(transactions.getDueDate());
//
//
//
//            Books books=transactions.getBooks();
//            books.setQuantity(books.getQuantity()+1);
//            Books books1= booksRepository.save(books);
//            transactions2.setBooks(books1);
//            transactions2.setMembers(transactions2.getMembers());
//            transactionRepository.save(transactions2);
        }
        return "success";
    }
}
