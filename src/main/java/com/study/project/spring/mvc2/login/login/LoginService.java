package com.study.project.spring.mvc2.login.login;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final SignUpRepository signUpRepository;

    public SignUpMember loginMember(String loginId, String password) {
        return signUpRepository.findByLoginId(loginId)
                .filter(m -> m.getPassword().equals(password))
                .orElse(null);
    }
}
