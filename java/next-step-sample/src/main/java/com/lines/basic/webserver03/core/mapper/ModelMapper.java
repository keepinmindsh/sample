package com.lines.basic.webserver03.core.mapper;

import com.lines.basic.webserver03.core.mapper.type.QueryStringParser;
import com.lines.basic.webserver03.core.mapper.type.ViewParser;

public class ModelMapper<ParamT, ReturnT> {
    public ReturnT parse(ParserType parserType, ParamT paramT){
        switch (parserType){
            case QueryString:
                return (ReturnT) new QueryStringParser(paramT).execute();
            default:
                return (ReturnT) new ViewParser(paramT).execute();
        }
    }
}
