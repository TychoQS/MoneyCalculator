package software.ulpgc.MoneyCalculator.architecture.io;

import java.io.IOException;
import java.util.Map;

public interface CurrencyCodeToSymbolLoader {
    Map<String, String> load() throws IOException;
}
