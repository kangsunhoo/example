package com.example.deme.Controller;

import com.example.deme.Dto.PostForm;
import com.example.deme.Dto.PostResponse;
import com.example.deme.Entity.Member;
import com.example.deme.Entity.Post;
import com.example.deme.Repository.MemberRepository;
import com.example.deme.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    private final PostRepository postRepository;
    private final MemberRepository memberRepository;

    @Autowired
    public PostController(PostRepository postRepository,MemberRepository memberRepository){
        this.postRepository = postRepository;
        this.memberRepository = memberRepository;
    }
    @GetMapping("/post")
    public List<PostResponse> getPosts(){
        List<Post> posts = postRepository.findAll();
        List<PostResponse> responses = posts.stream().map(post -> new PostResponse(post)).toList();
        return responses;
    }
    //Param: url뒤에 붙는 query parameter
    @PostMapping("/post")
    public PostResponse addPost(@RequestParam("id") Long id, @RequestBody PostForm form){
        System.out.println(form.toString());
        //Optional : 값이 존재하지 않을 때는 null을 반환
        Member member = memberRepository.findById(id).orElse(null);
        //formDTO에서 Post엔티티로 변환
        Post post = form.toEntity(member);
        //변환한 엔티티를 데이터베이스에 저장하고 값 출력
        Post result = postRepository.save(post);
        //저장된값을 PostResponseDTO로 변환
        PostResponse response = new PostResponse(result);
        //ResponseDTO내용 터미널에 출력
        System.out.println(response.toString());
        //ResponseDTO반
        return response;
    }
}
