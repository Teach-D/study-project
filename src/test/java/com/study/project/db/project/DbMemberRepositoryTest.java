package com.study.project.db.project;

import com.study.project.db.jdbc.repository.MemberRepositoryV3;
import com.study.project.db.project.domain.DbMember;
import com.study.project.db.project.repository.DbMemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.SQLException;

import static com.study.project.db.jdbc.connection.ConnectionConst.*;
import static org.assertj.core.api.Assertions.*;

@Slf4j
@RequiredArgsConstructor
public class DbMemberRepositoryTest {

    private DbMemberRepository memberRepository;
    private static long sequence = 0L;

    @BeforeEach
    void beforeEach() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource(URL, USERNAME, PASSWORD);
        memberRepository = new DbMemberRepository(dataSource);

    }


    @Test
    void save() throws SQLException {
/*        memberRepository.save("test1", "test1!");
        memberRepository.save("test2", "test2!");*/
        DbMember findById = memberRepository.findById(1L);
        assertThat(findById.getMemberId()).isEqualTo("test1");
        //memberRepository.delete(1L);
    }

    @Test
    void delete() throws SQLException {
        memberRepository.delete(1L);
    }

    @Test
    void update() throws SQLException {
        DbMember findMember = memberRepository.findById(2L);
        memberRepository.update(findMember, "newTest", "newTest!");
    }


/*    @Test
    void update() throws SQLException {
        DbMember findMember = memberRepository.findById(1L);
        memberRepository.update(findMember, "newTest", "newTest!");
    }

    @Test
    void delete() throws SQLException {
        memberRepository.delete(1L);
    }*/

}
