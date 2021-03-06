package com.lines.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class LogRQVO implements Serializable {
    private String content;
}
