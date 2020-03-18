package designpattern.gof_composite.sample001.speech;

import designpattern.gof_composite.sample001.RecorderType;

public class good extends RecorderType {

    @Override
    public String speak(int level) {
        String tab = "";
        return tab + "Good \r\n";
    }
}
