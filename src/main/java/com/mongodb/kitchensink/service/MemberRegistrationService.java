package com.mongodb.kitchensink.service;

import com.mongodb.kitchensink.exception.ResourceNotFoundException;
import com.mongodb.kitchensink.model.Member;
import com.mongodb.kitchensink.repository.MemberRepository;
import jakarta.validation.ValidationException;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberRegistrationService {
    private final MemberRepository repository;

    public MemberRegistrationService(MemberRepository repository) {
        this.repository = repository;
    }

    public List<Member> getAllMembers() {
        return repository.findAllByOrderByNameAsc();
    }

    public Member getUserById(String id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    public Member registerMember(Member member) {
        //validation
        validateMember(member);
        return repository.save(member);
    }

    private void validateMember(Member member) throws ValidationException {
        // Check the uniqueness of the email address
        if (emailAlreadyExists(member.getEmail())) {
            throw new ValidationException("Unique Email Violation");
        }
    }

    private boolean emailAlreadyExists(String email) {
        return repository.findByEmail(email) != null;
    }


}
