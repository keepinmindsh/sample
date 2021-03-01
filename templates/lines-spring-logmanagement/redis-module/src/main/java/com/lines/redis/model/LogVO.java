package com.lines.redis.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class LogVO implements Serializable {
    private String content;
}
