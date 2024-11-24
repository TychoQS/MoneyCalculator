package software.ulpgc.MoneyCalculator.architecture.control;

import software.ulpgc.MoneyCalculator.architecture.model.ExchangeRate;
import software.ulpgc.MoneyCalculator.architecture.model.Money;

public class MoneyConverter {
    public static Money convert(Money money, ExchangeRate exchangeRate) {
        System.out.println("Exchange rate: " + exchangeRate);
        return new Money(money.getAmount() * exchangeRate.getRate(), exchangeRate.getTo());
    }

}
