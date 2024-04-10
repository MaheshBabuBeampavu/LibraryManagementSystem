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
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

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

//                Optional<Transactions> ttt = transactionRepository.findByMembers(transactions.getMemberId());
//                if (ttt.isPresent()) {
//                    return "You have already borrowed the same book.";
//                }

                transactions1.setTransactionType(transactions.getType());
            Calendar calendar=Calendar.getInstance();
            Date ret=calendar.getTime();

//            calendar.setTime(new Date());
//            calendar.add(Calendar.WEEK_OF_YEAR,3);
//            Date due=calendar.getTime();
          String due= transactions1.getDueDate();
            transactions1.setDueDate(due);
            transactions1.setReturnDate(ret.toString());



           String bookId=transactions.getBookId();
           Optional<Books> books=booksRepository.findById(bookId);
           if(books.isPresent()) {
               Books books1=books.get();
               books1.setQuantity(books1.getQuantity()+1);
               Books books2 = booksRepository.save(books1);
               transactions1.setBooks(books2);

               String memberId=transactions.getMemberId();
               transactions1.setMembers(membersRepository.findById(memberId).get());


               transactionRepository.save(transactions1);
           }
        }
        else{
            Transactions transactions1=new Transactions();
//            Optional<Transactions> ttt =transactionRepository.findByMemberId(transactions.getMemberId());
//            if (ttt.isPresent()) {
//                return "You have already borrowed the same book.";
//            }

            transactions1.setTransactionType(transactions.getType());
            Calendar calendar=Calendar.getInstance();
            Date ret=calendar.getTime();
            calendar.setTime(new Date());
            calendar.add(Calendar.WEEK_OF_YEAR,6);
            Date due=calendar.getTime();


            transactions1.setDueDate(ret.toString());
          //  transactions1.setReturnDate(due.toString());



            String bookId=transactions.getBookId();
            Optional<Books> books=booksRepository.findById(bookId);
            if(books.isPresent()) {
                Books books1 = books.get();
                books1.setQuantity(books1.getQuantity() - 1);
                Books books2 = booksRepository.save(books1);
                transactions1.setBooks(books2);

                String memberId = transactions.getMemberId();
                transactions1.setMembers(membersRepository.findById(memberId).get());


                transactionRepository.save(transactions1);
            }

        }
        return "success";
    }

    @Override
    public Object getTransactionById(String id) {
        return transactionRepository.findById(id);
    }

    @Override
    public Object getTransactions() {
        return transactionRepository.findAll();
    }


}
