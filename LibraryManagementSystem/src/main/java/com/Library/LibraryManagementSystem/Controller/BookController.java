package com.Library.LibraryManagementSystem.Controller;

import com.Library.LibraryManagementSystem.Entity.Books;
import com.Library.LibraryManagementSystem.Entity.Members;
import com.Library.LibraryManagementSystem.Service.BookService;
import com.Library.LibraryManagementSystem.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/book")


public class BookController {
    @Autowired
    BookService bookService;
    @PostMapping("/create")
    public Object setBook(@RequestBody Books books){
       return bookService.setBook(books);


    }
    @GetMapping("/get")
    public Object getBooks(){
        return bookService.getBooks();
    }
    @GetMapping("/get/{id}")
    public Object getBookById(@PathVariable String id){
        return bookService.getBookById(id);
    }



        @GetMapping("/genre/{id}")
        public Object getBookByGenre(@PathVariable String id){
        return  bookService.getBookByGenre(id);

}
    @GetMapping("/genre/name/{name}")
    public Object getBookByName(@PathVariable("name") String name){
        return bookService.getBookByName(name);
    }
//    @GetMapping("author")
//    public Object getAuthor(@RequestParam long bookId){
//        return bookService.getAuthor(bookId);
//    }




}
