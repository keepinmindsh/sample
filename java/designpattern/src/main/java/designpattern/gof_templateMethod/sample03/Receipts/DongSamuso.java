package designpattern.gof_templateMethod.sample03.Receipts;

import designpattern.gof_templateMethod.sample03.Interface.Receipt;

public class DongSamuso implements Receipt {

    private final String finalContent;

    public DongSamuso(String finalContents){
        this.finalContent = finalContents;
    }

    @Override
    public String toString(){
        return finalContent;
    }
}
