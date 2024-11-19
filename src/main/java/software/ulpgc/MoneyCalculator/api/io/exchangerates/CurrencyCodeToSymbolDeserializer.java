package software.ulpgc.MoneyCalculator.api.io.exchangerates;

public interface CurrencyCodeToSymbolDeserializer {
    CurrencyCodeToSymbol deserialize(String line);
}
