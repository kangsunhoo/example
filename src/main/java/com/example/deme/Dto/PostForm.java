package com.example.deme.Dto;

import com.example.deme.Entity.Member;
import com.example.deme.Entity.Post;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class PostForm {
    private String title;
    private String content;

    public Post toEntity(Member member){
        return new Post(null,title,content,member);
    }
}


