package com.lines.log.reactor.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class LogDataRQVO {

    private List<LogVO> logVOList;

}
