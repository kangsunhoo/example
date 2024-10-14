package com.example.deme.Dto;

import com.example.deme.Entity.Member;
import lombok.*;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class MemberForm{
    private String name;
    private Long password;
    private String email;

    public Member toEntity(){
        //id는 자동생성되므로 값을 넣을 필요가 없다.
        return new Member(null,password,email,name,new ArrayList<>());
    }

}
