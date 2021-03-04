package com.lines.credit.model;

import com.lines.credit.code.SpecType;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ApprovalVO {
    private final ApprovalRequestVO requestVO;
    private final SpecType specType;
}
