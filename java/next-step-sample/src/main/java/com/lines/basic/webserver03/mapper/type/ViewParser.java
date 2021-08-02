package com.lines.basic.webserver03.mapper.type;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ViewParser<ParamT> implements Parser<String>{

    private final ParamT paramT;

    @Override
    public String execute() {
        return ((String)paramT).split(" ")[1];
    }
}
