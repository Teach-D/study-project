package com.study.project.spring.mvc2.typeconverter.converter;

import com.study.project.spring.mvc2.typeconverter.type.IpPort;
import org.springframework.core.convert.converter.Converter;

public class StringToIpPortConverter implements Converter<String, IpPort> {


    @Override
    public IpPort convert(String source) {
        String[] split = source.split(":");
        String ip = split[0];
        int port = Integer.parseInt(split[1]);
        return new IpPort(ip, port);

    }
}
