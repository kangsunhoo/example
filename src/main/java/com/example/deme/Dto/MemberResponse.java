package com.example.deme.Dto;

import com.example.deme.Entity.Member;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString

public class MemberResponse {
    private Long id;
    private String name;
    private Long password;
    private String email;
    private List<PostResponse> posts;

    public MemberResponse(Member member) {
        this.id = member.getId();
        this.name = member.getName();
        this.password = member.getPassword();
        this.email = member.getEmail();
        this.posts = member.getPosts().stream().map(post -> new PostResponse(post)).toList();

    }
}
