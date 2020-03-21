package basic.EffectiveJava.UsingDataTypeForCurrency;

import java.math.BigDecimal;

public class CorrentDataTypeForCurrency {
    public static void main(String[] args) {
        final BigDecimal TEN_CENTS = new BigDecimal("0.10");

        int itemsBought = 0;
        BigDecimal funds = new BigDecimal("1.00");
        for (BigDecimal price = TEN_CENTS; funds.compareTo(price) >= 0; price.add(TEN_CENTS)) {
            funds = funds.subtract(TEN_CENTS);
            itemsBought++;
        }
        System.out.println(itemsBought + " item Boughts.");
        System.out.println("Money left over : $" + funds);
    }
}
