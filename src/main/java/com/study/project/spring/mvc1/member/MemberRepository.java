package com.study.project.spring.mvc1.member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);
}
