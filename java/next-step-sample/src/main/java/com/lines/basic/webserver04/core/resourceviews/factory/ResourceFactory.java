package com.lines.basic.webserver04.core.resourceviews.factory;

import com.lines.basic.webserver04.core.resourceviews.Resource;
import com.lines.basic.webserver04.core.resourceviews.ResourceParam;
import com.lines.basic.webserver04.core.resourceviews.code.ResourceType;
import com.lines.basic.webserver04.core.resourceviews.viewer.DataView;
import com.lines.basic.webserver04.core.resourceviews.viewer.HTMLView;

public class ResourceFactory {
    public static Resource getResource(ResourceType resourceType, ResourceParam resourceParam) throws Exception{
        switch (resourceType){
            case DATA:
                return new DataView(resourceParam);
            case VIEW_HTML:
                return new HTMLView(resourceParam);
            default:
                throw new Exception();
        }
    }
}
