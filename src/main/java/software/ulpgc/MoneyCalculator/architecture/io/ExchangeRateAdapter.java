package software.ulpgc.MoneyCalculator.architecture.io;

import software.ulpgc.MoneyCalculator.architecture.model.Currency;
import software.ulpgc.MoneyCalculator.architecture.model.ExchangeRate;

public interface ExchangeRateAdapter {
    ExchangeRate adapt(Object object, Currency from, Currency to);
}