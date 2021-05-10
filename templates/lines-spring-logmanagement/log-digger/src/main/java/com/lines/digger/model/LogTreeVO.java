package com.lines.digger.model;


import lombok.*;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Getter
@Setter
@ToString
@Validated
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LogTreeVO {
    private String label;
    private String path;
    private boolean hasChild;
    private int childCount;
    private boolean isParent;
    private List<LogTreeVO> children;
}
