package designpattern.gof_composite.sample001.speech;

import designpattern.gof_composite.sample001.RecorderType;

public class top extends RecorderType {

    @Override
    public String speak(int level) {
        String tab = "";
        return tab + "상위 발음 \r\n";
    }
}
