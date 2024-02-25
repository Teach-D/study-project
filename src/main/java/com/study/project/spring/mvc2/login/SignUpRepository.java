package com.study.project.spring.mvc2.login;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@Slf4j
public class SignUpRepository {

    private static final Map<Long, SignUpMember> store = new HashMap<>();
    private static long sequence = 0L;

    public SignUpMember save(SignUpMember signUpMember) {
        signUpMember.setId(++sequence);
        store.put(signUpMember.getId(), signUpMember);
        return signUpMember;
    }
    public SignUpMember findById(Long id) {
        return store.get(id);
    }

    public Optional<SignUpMember> findByLoginId(String loginId) {
        return findAll().stream()
                .filter(m -> m.getLoginId().equals(loginId))
                .findFirst();
    }

    public List<SignUpMember> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
