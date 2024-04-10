package com.Library.LibraryManagementSystem.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Authors {
    @Id
    @GeneratedValue(generator = "UUID")

    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "author_id", updatable = false, nullable = false)
    String authorId;
    String authorName;
//    @OneToMany(mappedBy = "authors")
//
//    private List<BookAuthors> bookAuthors;
@ManyToMany(mappedBy = "authors")
private Set<Books> books = new HashSet<>();
}
