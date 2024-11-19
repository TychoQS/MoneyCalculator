package software.ulpgc.MoneyCalculator.api.io.exchangerates;

import software.ulpgc.MoneyCalculator.architecture.model.CurrencyCodeToSymbol;

public interface CurrencyCodeToSymbolDeserializer {
    CurrencyCodeToSymbol deserialize(String line);
}
