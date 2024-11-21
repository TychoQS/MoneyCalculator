package software.ulpgc.MoneyCalculator.architecture.io;

import java.io.IOException;

public interface CurrencyCodeToSymbolLoader {
    CurrencyCodeToSymbol load() throws IOException;
}
