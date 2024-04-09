package com.Library.LibraryManagementSystem.Repository;

import com.Library.LibraryManagementSystem.Entity.BookAuthors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface BookAuthorRepository extends JpaRepository<BookAuthors,Long> {
}
