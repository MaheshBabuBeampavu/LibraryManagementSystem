package com.Library.LibraryManagementSystem.Controller;

import com.Library.LibraryManagementSystem.Entity.Members;
import com.Library.LibraryManagementSystem.Service.MemberService;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

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
    public Object getMemberById(@PathVariable String id){
        return memberService.getMemberById(id);
    }
    @GetMapping("/members")
    public Object getMembers(){
        return memberService.getMembers();
    }



}
