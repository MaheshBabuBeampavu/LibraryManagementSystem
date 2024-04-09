package com.Library.LibraryManagementSystem.Controller;

import com.Library.LibraryManagementSystem.Entity.Members;
import com.Library.LibraryManagementSystem.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members")

public class MembersController {
    @Autowired
    MemberService memberService;
    @PostMapping("/post")
    public Object setMembers(@RequestBody Members members){
        return memberService.setMembers(members);

    }
    @GetMapping("/{id}")
    public Object getMemberById(@PathVariable long id){
        return memberService.getMemberById(id);
    }
    @GetMapping("/members")
    public Object getMembers(){
        return memberService.getMembers();
    }



}
