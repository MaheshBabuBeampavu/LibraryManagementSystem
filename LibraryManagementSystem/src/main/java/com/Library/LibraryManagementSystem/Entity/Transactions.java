package com.Library.LibraryManagementSystem.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Transactions {
    @Id
    @GeneratedValue(generator = "UUID")

    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "transaction_id", updatable = false, nullable = false)
    String transactionId;
    String transactionType;
    String dueDate;
    String returnDate;
@ManyToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "book_id")
@JsonIgnore
   private Books books;
@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="member_id")
@JsonIgnore
   private Members members;
}
