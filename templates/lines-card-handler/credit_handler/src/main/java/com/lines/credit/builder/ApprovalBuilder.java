package com.lines.credit.builder;

import com.lines.credit.code.ApprovalType;
import com.lines.credit.model.ApprovalRequestVO;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ApprovalBuilder {
    private final ApprovalRequestVO requestVO;
    private final ApprovalType approvalType;
}
