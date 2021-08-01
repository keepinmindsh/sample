package com.lines.basic.webserver03.resourceviews;

public class ResourceFactory {
    public static Resource getResource(ResourceType resourceType, ResourceParam resourceParam) throws Exception{
        switch (resourceType){
            case DATA:
                return new Data(resourceParam);
            case VIEW_HTML:
                return new ViewHTML(resourceParam);
            default:
                throw new Exception();
        }
    }
}
