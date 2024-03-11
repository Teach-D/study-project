package com.study.project.db.jdbc.repository;

import com.study.project.db.jdbc.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

@Slf4j
class MemberRepositoryV0Test {

    MemberRepositoryV0 repositoryV0 = new MemberRepositoryV0();

    @Test
    void crud() throws SQLException {
        Member member = new Member("memberV1", 10000);
        repositoryV0.save(member);

        Member findMember = repositoryV0.findById(member.getMemberId());
        log.info("findMember={}", findMember);
    }

}