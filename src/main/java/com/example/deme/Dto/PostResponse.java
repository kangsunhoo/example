package com.example.deme.Dto;

import com.example.deme.Entity.Post;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class PostResponse {
    private Long id;
    private String title;
    private String Content;
    private String memberName;

    public PostResponse(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.Content = post.getContent();
        this.memberName = post.getMember().getName();
    }
}
