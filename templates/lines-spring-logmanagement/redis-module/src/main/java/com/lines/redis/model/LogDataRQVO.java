package com.lines.redis.model;

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
