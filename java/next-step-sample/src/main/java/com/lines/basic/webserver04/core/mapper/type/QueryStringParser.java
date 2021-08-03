package com.lines.basic.webserver04.core.mapper.type;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class QueryStringParser<ParamT> implements Parser<String> {

    private final ParamT paramT;

    @Override
    public String execute() {

        String url = ((String)paramT).split(" ")[1];

        String parameter = url.split("\\?")[1];

        return parameter;
    }
}
