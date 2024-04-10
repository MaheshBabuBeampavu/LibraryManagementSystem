package com.Library.LibraryManagementSystem.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.print.DocFlavor;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor


public class Members {
    @Id
    @GeneratedValue(generator = "UUID")

    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "member_id", updatable = false, nullable = false)
    String memberId;
    String name;
    String address;
    Long phoneNumber;
    String email;
    @OneToMany(mappedBy = "members")
    @JsonIgnore
    private List<Transactions> transactions;

}
