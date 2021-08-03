package com.lines.basic.webserver04.core.resourceviews.viewer;

import com.lines.basic.webserver04.core.RequestHandlerPost;
import com.lines.basic.webserver04.core.resourceviews.Resource;
import com.lines.basic.webserver04.core.resourceviews.ResourceParam;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class HTMLView implements Resource {
    private final ResourceParam resourceParam;

    @Override
    public Object call() throws Exception {
        return RequestHandlerPost
                .class
                .getResourceAsStream("/templates" + resourceParam.getScreen())
                .readAllBytes();
    }
}
