package com.lines.model;

import com.lines.model.status.UserStatus;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LogRSVO<ResultR> {
    private final UserStatus userStatus;
    private final ResultR result;
}
