package com.lines.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class LogDataRQVO {
    private List<LogRQVO> logRQVOList;
}
