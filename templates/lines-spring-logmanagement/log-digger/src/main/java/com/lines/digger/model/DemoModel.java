package com.lines.digger.model;

import lombok.*;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
@Setter
@ToString
@Validated
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DemoModel {

    private String id;
    private Map<String, String> data;
    private LocalDateTime createDateTime = LocalDateTime.now();
    private String source;
    private double version = 1.0;

}
