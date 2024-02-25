package com.study.project.spring.mvc1.lifecycle;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private final MyLogger myLogger;
    private final LogDemoService logDemoService;

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request) {
        StringBuffer requestURL = request.getRequestURL();
        myLogger.setRequestURL(String.valueOf(requestURL));

        myLogger.log("controller test");
        logDemoService.logic("testId");
        return "OK";
    }
}
