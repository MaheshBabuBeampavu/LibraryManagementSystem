package com.Library.LibraryManagementSystem.Controller;

import com.Library.LibraryManagementSystem.Entity.Members;
import com.Library.LibraryManagementSystem.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/members")

public class MembersController {
    @Autowired
    MemberService memberService;
    @PostMapping("/post")
    public Object setMembers(@RequestBody Members members){
        return memberService.setMembers(members);

    }

}
