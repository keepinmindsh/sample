package com.lines.basic.webserver04.domain.user.model;

import com.lines.basic.webserver04.core.code.StatusCode;
import lombok.Builder;
import lombok.Getter;

public class UserDto {

    @Getter
    @Builder
    public static class Result{
        private final StatusCode statusCode;
        private final Object result;
    }
}
