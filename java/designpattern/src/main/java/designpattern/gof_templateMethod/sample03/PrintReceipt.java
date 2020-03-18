package designpattern.gof_templateMethod.sample03;

import designpattern.gof_templateMethod.sample03.Interface.Receipt;

public abstract class PrintReceipt {

    public Receipt printReceipt(){

        String finalContents = getASign(applyContent(getBusiness()));

        return getReceipt(finalContents);

    }

    public abstract String getBusiness();

    public abstract String applyContent(String business);

    public abstract String getASign(String Content);

    public abstract Receipt getReceipt(String Final);
}
