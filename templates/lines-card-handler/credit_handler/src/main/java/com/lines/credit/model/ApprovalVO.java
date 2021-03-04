package com.lines.credit.model;

import com.lines.credit.code.ApprovalType;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Approval {
    private final ApprovalRequestVO requestVO;
    private final ApprovalType approvalType;
}
