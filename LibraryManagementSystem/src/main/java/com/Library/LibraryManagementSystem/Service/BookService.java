package com.Library.LibraryManagementSystem.Service;

import com.Library.LibraryManagementSystem.Entity.Books;

import java.util.Optional;
import java.util.UUID;


public interface BookService {
    Object setBook(Books books);

   public Object getBooks();

  public Object getBookById(String id);

    Object getBookByGenre(String id);

    Object getBookByName(String name);

//    Object getAuthor(long bookId);
}
