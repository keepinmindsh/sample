package com.lines.basic.webserver04.core.mapper.type;

import com.lines.basic.webserver04.core.mapper.ModelParam;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CustomParser implements Parser<Object> {

    private final ModelParam modelParam;

    @Override
    public Object execute() {
        return modelParam
                .getMapping()
                .map();
    }
}
