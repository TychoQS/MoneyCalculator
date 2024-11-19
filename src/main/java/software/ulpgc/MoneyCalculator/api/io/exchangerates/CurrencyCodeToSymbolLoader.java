package software.ulpgc.MoneyCalculator.api.io.exchangerates;

import java.io.IOException;
import java.util.Map;

public interface CurrencyCodeToSymbolLoader {
    Map<String, String> load() throws IOException;
}
