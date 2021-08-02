package com.lines.basic.webserver03.resourceviews.viewer;

import com.lines.basic.webserver03.RequestHandler;
import com.lines.basic.webserver03.resourceviews.Resource;
import com.lines.basic.webserver03.resourceviews.ResourceParam;
import lombok.RequiredArgsConstructor;

import java.io.IOException;

@RequiredArgsConstructor
public class HTMLView implements Resource {
    private final ResourceParam resourceParam;

    @Override
    public Object call() throws Exception {
        return RequestHandler
                .class
                .getResourceAsStream("/templates" + resourceParam.getScreen())
                .readAllBytes();
    }
}
