package com.lines.credit.command;

import com.lines.credit.builder.ApprovalBuilder;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ApprovalCommand {

    private final ApprovalBuilder creditBuilder;

}
