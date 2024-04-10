package com.Library.LibraryManagementSystem.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Books {
    @Id
    @GeneratedValue(generator = "UUID")

    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "book_id", updatable = false, nullable = false)
    private String id;
    String title;
    String author;
    String isbn;
    Long publicationYear;
    Long quantity;
    @ManyToOne(cascade =  CascadeType.ALL)
    @JoinColumn(name = "publisher_id")
//    @JsonIgnore
    private Publishers publishers;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "genre_id")
//    @JsonIgnore
    private Genres genres;

//    @OneToOne(mappedBy = "books")
////    @JsonIgnore
//    private BookAuthors bookAuthors;


    @OneToMany(mappedBy = "books")
//    @JsonIgnore
    private List<Transactions> transactions;
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "book_author",
        joinColumns = { @JoinColumn(name = "book_id") },
        inverseJoinColumns = { @JoinColumn(name = "author_id") }
    )
    private Set<Authors> authors = new HashSet<>();

}
