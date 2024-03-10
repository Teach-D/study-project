package com.study.project.spring.mvc2.login.login;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class SignUpMember {

    private Long id;

    @NotEmpty
    private String loginId;
    @NotEmpty
    private String name;
    @NotEmpty
    private String password;
}
