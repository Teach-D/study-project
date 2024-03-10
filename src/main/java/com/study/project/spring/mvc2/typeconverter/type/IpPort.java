package com.study.project.spring.mvc2.typeconverter.type;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Data
public class IpPort {

    private String ip;
    private int port;

    public IpPort(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }
}
