package com.study.project.db.project.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DbMember {

    private long Id;
    private String memberId;
    private String password;

    public DbMember() {
    }
}
