package com.lines.digger.model;


import lombok.*;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@ToString
@Validated
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LogTreeVO {
    private String folder;
    private boolean hasChild;
}
