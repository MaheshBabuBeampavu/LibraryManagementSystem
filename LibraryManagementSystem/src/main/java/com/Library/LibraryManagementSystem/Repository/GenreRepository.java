package com.Library.LibraryManagementSystem.Repository;

import com.Library.LibraryManagementSystem.Entity.Genres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface GenreRepository extends JpaRepository<Genres,Long> {


    Genres findByGenreName(String name);
}
