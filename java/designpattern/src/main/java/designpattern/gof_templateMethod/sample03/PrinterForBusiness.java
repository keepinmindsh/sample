package designpattern.gof_templateMethod.sample03;

import designpattern.gof_templateMethod.sample03.Businesses.BankReceipt;
import designpattern.gof_templateMethod.sample03.Businesses.DongSamusoReceipt;
import designpattern.gof_templateMethod.sample03.Businesses.PosReceipt;
import designpattern.gof_templateMethod.sample03.Interface.Receipt;

import java.util.Arrays;
import java.util.List;

public class PrinterForBusiness {
    public static void main(String[] args) {

        PrintReceipt BANKReceipt1 = new BankReceipt();
        PrintReceipt DongSamusoReceipt2 = new DongSamusoReceipt();
        PrintReceipt POSReceipt3 = new PosReceipt();

        List<Receipt> listReceipt = Arrays.asList(BANKReceipt1.printReceipt(), DongSamusoReceipt2.printReceipt(), POSReceipt3.printReceipt());

        listReceipt.forEach(receipt -> {
            System.out.println(receipt.toString());
        });
    }
}
