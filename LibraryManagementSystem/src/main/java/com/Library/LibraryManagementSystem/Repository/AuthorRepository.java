package com.Library.LibraryManagementSystem.Repository;

import com.Library.LibraryManagementSystem.Entity.Authors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface AuthorRepository extends JpaRepository<Authors,Long> {
}
