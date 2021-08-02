package com.lines.basic.webserver03.resourceviews;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ResourceParam {
    private final String screen;
    private final String url;
}
