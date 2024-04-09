package com.Library.LibraryManagementSystem.Service;

import com.Library.LibraryManagementSystem.Entity.Members;
import com.Library.LibraryManagementSystem.Repository.MembersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class MemberServiceIml implements MemberService{
    @Autowired
    MembersRepository membersRepository;
    @Override
    public Object setMembers(Members members) {
       Members members1=new Members();
       members1.setName(members.getName());
       members1.setEmail(members.getEmail());
       members1.setAddress(members.getAddress());
       members1.setPhoneNumber(members.getPhoneNumber());
     return  membersRepository.save(members1);
    }
}
