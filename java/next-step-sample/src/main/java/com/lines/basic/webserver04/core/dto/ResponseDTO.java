package com.lines.basic.webserver04.core.dto;

import com.lines.basic.webserver04.core.code.ResponseCode;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ResponseDTO {

    private final byte[] body;
    private final ResponseCode responseCode;
}
