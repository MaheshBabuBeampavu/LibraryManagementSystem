package com.Library.LibraryManagementSystem.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.print.DocFlavor;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor


public class Members {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
            @Column(name = "member_id")
    Long memberId;
    String name;
    String address;
    Long phoneNumber;
    String email;
    @OneToMany(mappedBy = "members")
    @JsonIgnore
    private List<Transactions> transactions;

}
