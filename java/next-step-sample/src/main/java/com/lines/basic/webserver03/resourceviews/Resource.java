package com.lines.basic.webserver03.resourceviews;

import java.io.IOException;

public interface Resource {
    public Object call() throws Exception;
}
