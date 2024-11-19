package com.mongodb.kitchensink.controller;

import com.mongodb.kitchensink.model.Member;
import com.mongodb.kitchensink.service.MemberRegistrationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/members")
public class MemberController {

    @Autowired
    private MemberRegistrationService memberService;

    /*@GetMapping
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }

    @PostMapping
    public Member addMember(@RequestBody Member member) {
        return memberService.registerMember(member);
    }*/

    @GetMapping
    public String getAllMembers(Model model) {
        System.out.println("Fetched all members");
        model.addAttribute("members", memberService.getAllMembers());
        return "index";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("members", new Member());
        return "user-form";
    }

    @PostMapping
    public String createUser(@Valid @ModelAttribute Member member) {
        memberService.registerMember(member);
        return "redirect:/api/members";
    }

    @GetMapping("/{id}")
    public String showMemberDetails(@PathVariable String id, Model model) {
        model.addAttribute("members", memberService.getUserById(id));
        return "user-details";
    }

}
