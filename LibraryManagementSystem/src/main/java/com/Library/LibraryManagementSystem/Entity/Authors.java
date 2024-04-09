package com.Library.LibraryManagementSystem.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Authors {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long authorId;
    String authorName;
    @OneToMany(mappedBy = "authors")

    private List<BookAuthors> bookAuthors;
}
