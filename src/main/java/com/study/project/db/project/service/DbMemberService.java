package com.study.project.db.project.service;

import com.study.project.db.project.repository.DbMemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.SQLException;

@Slf4j
@Service
@RequiredArgsConstructor
public class DbMemberService {

    private final DbMemberRepository memberRepository;

    @Transactional
    public void signup(Long id, String memberId, String password) throws SQLException {
        bizLogic(id, memberId, password);
    }

    private void bizLogic(Long id, String memberId, String password) throws SQLException {
        memberRepository.save(id, memberId,password);
        validation(memberId);
    }

    private void validation(String memberId) {
        if(memberId.equals("ex")) {
            throw new RuntimeException("회원가입 아이디가 ex입니다");
        }
    }
}
