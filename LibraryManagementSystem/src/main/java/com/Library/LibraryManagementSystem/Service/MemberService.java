package com.Library.LibraryManagementSystem.Service;

import com.Library.LibraryManagementSystem.Entity.Members;

import java.util.UUID;

public interface MemberService {
    Object setMembers(Members members);

    Object getMemberById(String id);

    Object getMembers();
}
