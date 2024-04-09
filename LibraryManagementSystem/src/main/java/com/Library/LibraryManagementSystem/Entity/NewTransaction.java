package com.Library.LibraryManagementSystem.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class NewTransaction {
 Long bookId;
 String type;
Long memberId;

}
