package software.ulpgc.MoneyCalculator.architecture.model;

public interface CurrencyCodeToSymbolDeserializer {
    CurrencyCodeToSymbol deserialize(String line);
}
