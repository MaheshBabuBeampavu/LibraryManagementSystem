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


public class Publishers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
            @Column(name = "publisher_id")
    Long publisherId;
    String publisherName;
    @OneToMany(mappedBy = "publishers")
    @JsonIgnore
    private List<Books> books;


}
