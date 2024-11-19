package software.ulpgc.MoneyCalculator.architecture.io;

import software.ulpgc.MoneyCalculator.architecture.model.CurrencyCodeToSymbol;

public interface CurrencyCodeToSymbolDeserializer {
    CurrencyCodeToSymbol deserialize(String line);
}
