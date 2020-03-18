package designpattern.gof_templateMethod.sample03.Businesses;

import designpattern.gof_templateMethod.sample03.Interface.Receipt;
import designpattern.gof_templateMethod.sample03.PrintReceipt;
import designpattern.gof_templateMethod.sample03.Receipts.POS;

public class PosReceipt extends PrintReceipt {
    @Override
    public String getBusiness() {
        return "포스";
    }

    @Override
    public String applyContent(String business) {
        return business + " : " + "나는 포스 영수증입니다.";
    }

    @Override
    public String getASign(String content) {
        return content + " [사인] 나는 포스 사인입니다.";
    }

    @Override
    public Receipt getReceipt(String FinalContents) {
        return new POS(FinalContents);
    }
}
