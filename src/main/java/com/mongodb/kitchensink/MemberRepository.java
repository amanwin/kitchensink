package com.mongodb.kitchensink.repository;

import com.mongodb.kitchensink.model.Member;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MemberRepository extends MongoRepository<Member, String> {
    List<Member> findAllByOrderByNameAsc(); // Ascending order by name
    Member findByEmail(String email);
}
