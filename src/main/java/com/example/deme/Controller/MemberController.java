package com.example.deme.Controller;

import com.example.deme.Dto.MemberForm;
import com.example.deme.Dto.MemberResponse;
import com.example.deme.Dto.PostResponse;
import com.example.deme.Entity.Member;
import com.example.deme.Entity.Post;
import com.example.deme.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//컨트롤러를 restApi로 만들어 준다.
@RestController
public class MemberController {

    //DI(의존성 주입) dependency Injection
    private final MemberRepository memberRepository;

    @Autowired
    public MemberController(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    @GetMapping("/")
    public String helloworld(){
        return "hello world";
    }

    @GetMapping("/user")
    public List<MemberResponse> getUser(){
        List<Member> members = memberRepository.findAll();
        List<MemberResponse> responses =members.stream().map(MemberResponse::new).toList() ;
        return responses;
    }

    @PostMapping("/user")
    public MemberResponse createMember(@RequestBody MemberForm form){
        System.out.println(form.toString());
        Member member = form.toEntity();
        Member result = memberRepository.save(member);
        return new MemberResponse(result);

    }
}
