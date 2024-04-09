package com.Library.LibraryManagementSystem.Repository;

import com.Library.LibraryManagementSystem.Entity.Publishers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PublisherRepository extends JpaRepository<Publishers,Long> {
}
