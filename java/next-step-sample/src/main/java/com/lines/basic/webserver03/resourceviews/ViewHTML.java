package com.lines.basic.webserver03.resourceviews;

import com.lines.basic.webserver03.RequestHandler;
import lombok.RequiredArgsConstructor;

import java.io.IOException;

@RequiredArgsConstructor
public class ViewHTML implements Resource {
    private final ResourceParam resourceParam;

    @Override
    public Object call() throws Exception {
        return RequestHandler
                .class
                .getResourceAsStream("/templates" + resourceParam.getScreen())
                .readAllBytes();
    }
}
