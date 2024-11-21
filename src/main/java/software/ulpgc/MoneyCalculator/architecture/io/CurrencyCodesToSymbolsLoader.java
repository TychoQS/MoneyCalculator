package software.ulpgc.MoneyCalculator.architecture.io;

import java.io.IOException;

public interface CurrencyCodesToSymbolsLoader {
    CurrencyCodesToSymbols load() throws IOException;
}
