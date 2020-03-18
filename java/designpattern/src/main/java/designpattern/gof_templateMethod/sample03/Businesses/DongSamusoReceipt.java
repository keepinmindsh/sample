package designpattern.gof_templateMethod.sample03.Businesses;

import designpattern.gof_templateMethod.sample03.Interface.Receipt;
import designpattern.gof_templateMethod.sample03.PrintReceipt;
import designpattern.gof_templateMethod.sample03.Receipts.DongSamuso;

public class DongSamusoReceipt extends PrintReceipt {
    @Override
    public String getBusiness() {
        return "동사무서";
    }

    @Override
    public String applyContent(String business) {
        return business + " : " + "나는 동사무소 영수증입니다.";
    }

    @Override
    public String getASign(String content) {
        return content + " [사인] 나는 동사무소 사인입니다.";
    }

    @Override
    public Receipt getReceipt(String FinalContents) {
        return new DongSamuso(FinalContents);
    }
}
