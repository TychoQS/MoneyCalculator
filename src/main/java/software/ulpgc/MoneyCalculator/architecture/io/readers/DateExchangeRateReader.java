package software.ulpgc.MoneyCalculator.architecture.io.readers;

import java.io.IOException;
import java.time.ZonedDateTime;

public interface DateExchangeRateReader {
    String read(String fromCurrencyCode, String toCurrencyCode, ZonedDateTime date) throws IOException;
}
