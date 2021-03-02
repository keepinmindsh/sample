package com.lines.log.reactor.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class LogVO implements Serializable {
    private String content;
}
