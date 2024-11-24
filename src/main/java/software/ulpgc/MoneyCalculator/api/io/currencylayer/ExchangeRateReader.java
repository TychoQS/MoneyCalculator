package software.ulpgc.MoneyCalculator.api.io.currencylayer;

import java.io.IOException;

public interface ExchangeRateReader {
    String read(String fromCurrencyCode, String toCurrencyCode) throws IOException;
}
