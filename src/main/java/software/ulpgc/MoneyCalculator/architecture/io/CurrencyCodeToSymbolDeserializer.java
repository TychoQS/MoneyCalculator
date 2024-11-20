package software.ulpgc.MoneyCalculator.architecture.io;

public interface CurrencyCodeToSymbolDeserializer {
    CurrencyCodeToSymbol deserialize(String line);
}
