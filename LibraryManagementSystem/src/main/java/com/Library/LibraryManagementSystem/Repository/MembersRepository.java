package com.Library.LibraryManagementSystem.Repository;

import com.Library.LibraryManagementSystem.Entity.Members;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository

public interface MembersRepository extends JpaRepository<Members, String> {

//    Object findByName(String );
}
