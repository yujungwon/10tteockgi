package com.project._tteockgi.domain.member.service;

import com.project._tteockgi.domain.member.entity.Member;
import com.project._tteockgi.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public List<Member> findAll(){
        return memberRepository.findAll();
    }

    public Member create (String username, String name, String email, String password) {
        Member member = new Member();

        member.setUsername(username);
        member.setName(name);
        member.setEmail(email);
        member.setPassword(passwordEncoder.encode(password));

        return this.memberRepository.save(member);
    }

    public Optional<Member> findById(Long id) {
        return this.memberRepository.findById(id);
    }
}
