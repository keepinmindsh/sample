package com.lines.basic.webserver03.resourceviews.factory;

import com.lines.basic.webserver03.resourceviews.Resource;
import com.lines.basic.webserver03.resourceviews.ResourceParam;
import com.lines.basic.webserver03.resourceviews.ResourceType;
import com.lines.basic.webserver03.resourceviews.viewer.DataView;
import com.lines.basic.webserver03.resourceviews.viewer.HTMLView;

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
