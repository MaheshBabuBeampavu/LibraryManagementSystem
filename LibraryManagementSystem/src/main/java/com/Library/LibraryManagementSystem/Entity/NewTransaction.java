package com.Library.LibraryManagementSystem.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class NewTransaction {
 String bookId;
 String type;
String memberId;

}
