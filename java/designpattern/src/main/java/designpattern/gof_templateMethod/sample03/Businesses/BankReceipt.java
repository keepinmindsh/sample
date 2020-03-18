package designpattern.gof_templateMethod.sample03.Businesses;

import designpattern.gof_templateMethod.sample03.Interface.Receipt;
import designpattern.gof_templateMethod.sample03.PrintReceipt;
import designpattern.gof_templateMethod.sample03.Receipts.Bank;

public class BankReceipt extends PrintReceipt {

    @Override
    public String getBusiness() {
        return "은행";
    }

    @Override
    public String applyContent(String business) {
        return business + " : " + "나는 은행 영수증입니다.";
    }

    @Override
    public String getASign(String content) {
        return content + " [사인] 은행 영수증을 위한 사인입니다";
    }

    @Override
    public Receipt getReceipt(String FinalContents) {
        return new Bank(FinalContents);
    }
}
