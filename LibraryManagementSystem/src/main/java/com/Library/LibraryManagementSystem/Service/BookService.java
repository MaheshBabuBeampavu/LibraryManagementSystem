package com.Library.LibraryManagementSystem.Service;

import com.Library.LibraryManagementSystem.Entity.Books;

import java.util.Optional;


public interface BookService {
    void setBook(Books books);

   public Object getBooks();

  public Optional<Books> getBookById(Long id);
}
