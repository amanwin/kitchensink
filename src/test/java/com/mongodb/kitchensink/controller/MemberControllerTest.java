package com.mongodb.kitchensink.controller;

import com.mongodb.kitchensink.model.Member;
import com.mongodb.kitchensink.service.MemberRegistrationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class MemberControllerTest {

    @Autowired
    private MemberRegistrationService service;

    @Test
    void testAddMember() {
        Member member = new Member();
        member.setName("John Doe");
        member.setEmail("john.doe@example.com");
        Member savedMember = service.registerMember(member);

        assertThat(savedMember.getId()).isNotNull();
    }
}
