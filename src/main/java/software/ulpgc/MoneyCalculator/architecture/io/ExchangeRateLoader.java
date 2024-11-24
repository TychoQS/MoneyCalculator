package software.ulpgc.MoneyCalculator.architecture.io;

import software.ulpgc.MoneyCalculator.architecture.model.Currency;
import software.ulpgc.MoneyCalculator.architecture.model.ExchangeRate;

import java.io.IOException;

public interface ExchangeRateLoader {
    ExchangeRate load() throws IOException;
}
