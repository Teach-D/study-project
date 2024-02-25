package com.study.project.spring.mvc1.lifecycle;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoService {

    private final MyLogger myLogger;
    public void logic(String testId) {
        myLogger.log("service id = " + testId);
    }
}
