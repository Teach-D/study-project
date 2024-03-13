package com.study.project.db.project.repository;

import com.study.project.db.jdbc.connection.DBConnectionUtil;
import com.study.project.db.project.domain.DbMember;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.NoSuchElementException;

@Repository
@Slf4j
@RequiredArgsConstructor
public class DbMemberRepository {

    private final DataSource dataSource;

    public void save(Long id,String memberId, String password) throws SQLException {
        String sql = "insert into member(id, member_id, password) values(?,?,?)";
        log.info(String.valueOf(id));

        try {
            Connection con = null;
            PreparedStatement pstmt;
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setLong(1, id);
            pstmt.setString(2, memberId);
            pstmt.setString(3, password);

            pstmt.execute();
        } catch (SQLException e) {
            throw new SQLException("sql exception");
        }

    }

    public DbMember findById(Long id) throws SQLException {
        String sql = "select * from member where id=?";

        Connection con = null;
        PreparedStatement pstmt;
        con = getConnection();
        pstmt = con.prepareStatement(sql);
        pstmt.setLong(1, id);

        ResultSet rs = pstmt.executeQuery();
        if(rs.next()) {
            DbMember member = new DbMember();
            member.setId(id);
            member.setMemberId(rs.getString("member_id"));
            member.setPassword(rs.getString("password"));
            return member;
        } else {
            throw new NoSuchElementException("member not found id=" + id);
        }

    }

    public DbMember update(DbMember originalMember, String memberId, String password) throws SQLException {
        String sql = "update member set member_id=?, password=? where id=?";

        Connection con = null;
        PreparedStatement pstmt;
        con = getConnection();
        pstmt = con.prepareStatement(sql);
        pstmt.setString(1, memberId);
        pstmt.setString(2, password);
        pstmt.setLong(3, originalMember.getId());

        pstmt.executeUpdate();

        DbMember member = new DbMember(originalMember.getId(), memberId, password);
        log.info(String.valueOf(member));
        return member;
    }

    public void delete(Long id) throws SQLException {
        String sql = "delete from member where id=?";

        Connection con = null;
        PreparedStatement pstmt;
        con = getConnection();
        pstmt = con.prepareStatement(sql);
        pstmt.setLong(1, id);

        pstmt.executeUpdate();
    }

    private Connection getConnection() {
        Connection con = DataSourceUtils.getConnection(dataSource);
        return con;
    }
}
