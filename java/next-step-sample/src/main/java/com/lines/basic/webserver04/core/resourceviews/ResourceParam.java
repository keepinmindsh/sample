package com.lines.basic.webserver04.core.resourceviews;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ResourceParam {
    private final String screen;
    private final String url;
}
