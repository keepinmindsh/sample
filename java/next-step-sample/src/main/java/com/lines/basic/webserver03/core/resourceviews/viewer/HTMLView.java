package com.lines.basic.webserver03.core.resourceviews.viewer;

import com.lines.basic.webserver03.core.RequestHandlerTemplate;
import com.lines.basic.webserver03.core.resourceviews.Resource;
import com.lines.basic.webserver03.core.resourceviews.ResourceParam;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class HTMLView implements Resource {
    private final ResourceParam resourceParam;

    @Override
    public Object call() throws Exception {
        return RequestHandlerTemplate
                .class
                .getResourceAsStream("/templates" + resourceParam.getScreen())
                .readAllBytes();
    }
}
