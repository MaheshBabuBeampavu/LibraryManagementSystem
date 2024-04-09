package com.Library.LibraryManagementSystem.Service;

import com.Library.LibraryManagementSystem.Entity.*;
import com.Library.LibraryManagementSystem.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    BooksRepository booksRepository;
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    PublisherRepository publisherRepository;
    @Autowired
    GenreRepository genreRepository;
    @Autowired
    BookAuthorRepository bookAuthorRepository;

    @Override
    public void setBook(Books books) {
      //  booksRepository.save(books);
        Genres genres=new Genres();
        genres.setGenreName(books.getGenres().getGenreName());
        Genres genres1=genreRepository.save(genres);


        Authors authors=new Authors();
        authors.setAuthorName(books.getAuthor());
      Authors authors1 = authorRepository.save(authors);


        Publishers publishers=new Publishers();
        publishers.setPublisherName(books.getPublishers().getPublisherName());
      Publishers publishers1=  publisherRepository.save(publishers);

        Books books1=new Books();
        books1.setTitle(books.getTitle());
        books1.setAuthor(books.getAuthor());
        books1.setIsbn(books.getIsbn());
        books1.setPublicationYear(books.getPublicationYear());
        books1.setQuantity(books.getQuantity());
        books1.setPublishers(publishers1);
        books1.setGenres(genres1);
     //   books1.setId(UUID.randomUUID());
       // books1.setBookAuthors(bookAuthors1);

        Books books2= booksRepository.save(books1);

        BookAuthors bookAuthors=new BookAuthors();
        bookAuthors.setAuthors(authors1);
        bookAuthors.setBooks(books2);
        bookAuthorRepository.save(bookAuthors);








    }


@Override
public Object getBooks() {
    List<Books> booksList = booksRepository.findAll();
    List<Books> modifiedBooksList = new ArrayList<>();

    for (Books book : booksList) {
        Books modifiedBook = new Books();
      //  modifiedBook.setBookId(book.getBookId());
        modifiedBook.setTitle(book.getTitle());
        modifiedBook.setAuthor(book.getAuthor());
        modifiedBook.setIsbn(book.getIsbn());
        modifiedBook.setPublicationYear(book.getPublicationYear());
        modifiedBook.setQuantity(book.getQuantity());

        Publishers publisher = new Publishers();
        publisher.setPublisherId(book.getPublishers().getPublisherId());
        publisher.setPublisherName(book.getPublishers().getPublisherName());
        modifiedBook.setPublishers(publisher);

        Genres genre = new Genres();
        genre.setGenreId(book.getGenres().getGenreId());
        genre.setGenreName(book.getGenres().getGenreName());
        modifiedBook.setGenres(genre);


        modifiedBooksList.add(modifiedBook);
    }

    return modifiedBooksList;
}

    @Override
    public Optional<Books> getBookById(Long id) {
        return booksRepository.findById(id);
    }

    @Override
    public Object getBookByGenre(long id) {
        Genres genres=genreRepository.findById(id).get();
        return genres.getBooks();
    }

    @Override
    public Object getBookByName(String name) {
        Genres genres=genreRepository.findByGenreName(name);
        return  genres.getBooks();
    }

    @Override
    public Object getAuthor(long bookId) {
        Books books=booksRepository.findById(bookId).get();
       BookAuthors bookAuthors= books.getBookAuthors();
       return  bookAuthors.getAuthors();

    }
}
