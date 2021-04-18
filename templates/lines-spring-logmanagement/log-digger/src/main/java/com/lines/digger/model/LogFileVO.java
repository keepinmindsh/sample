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
public class LogFileVO {
    private String fileName;
    private String filePath;
    private String createdDate;
}
