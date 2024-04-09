package com.Library.LibraryManagementSystem.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor


public class BookAuthors {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
    @OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "book_id")
          @JsonIgnore
    Books books;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    @JsonIgnore
   private Authors authors;

//    private Books bookId;
//    private Authors authorId;

}
