package com.Library.LibraryManagementSystem.Controller;

import com.Library.LibraryManagementSystem.Entity.Books;
import com.Library.LibraryManagementSystem.Entity.Members;
import com.Library.LibraryManagementSystem.Service.BookService;
import com.Library.LibraryManagementSystem.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")


public class BookController {
    @Autowired
    BookService bookService;
    @PostMapping("/create")
    public Object setBook(@RequestBody Books books){
        bookService.setBook(books);
        return "Success";

    }
    @GetMapping("/get")
    public Object getBooks(){
        return bookService.getBooks();
    }
    @GetMapping("/get/{id}")
    public Object getBookById(@PathVariable Long id){
        return bookService.getBookById(id);
    }




}
