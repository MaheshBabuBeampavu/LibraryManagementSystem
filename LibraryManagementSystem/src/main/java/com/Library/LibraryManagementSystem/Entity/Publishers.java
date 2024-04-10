package com.Library.LibraryManagementSystem.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor


public class Publishers {
    @Id
    @GeneratedValue(generator = "UUID")

    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "publisher_id", updatable = false, nullable = false)
    String publisherId;
    String publisherName;
    @OneToMany(mappedBy = "publishers")
    @JsonIgnore
    private List<Books> books;


}
