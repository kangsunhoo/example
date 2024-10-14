package com.example.deme.Repository;

import com.example.deme.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {
}
