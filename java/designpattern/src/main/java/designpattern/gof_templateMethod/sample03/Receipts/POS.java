package designpattern.gof_templateMethod.sample03.Receipts;

import designpattern.gof_templateMethod.sample03.Interface.Receipt;

public class POS implements Receipt {

    private final String finalContent;

    public POS(String finalContents){
        this.finalContent = finalContents;
    }

    @Override
    public String toString(){
        return finalContent;
    }
}
