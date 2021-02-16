package com.lines.credit.model;

import com.lines.credit.code.AlertType;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Alert {
    private final AlertType alertType;
}
