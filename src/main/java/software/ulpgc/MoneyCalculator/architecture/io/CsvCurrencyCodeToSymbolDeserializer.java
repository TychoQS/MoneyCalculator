package software.ulpgc.MoneyCalculator.architecture.io;

public class CsvCurrencyCodeToSymbolDeserializer implements CurrencyCodeToSymbolDeserializer {
    @Override
    public CurrencyCodeToSymbol deserialize(String line) {
        return deserialize(line.split(","));
    }

    private CurrencyCodeToSymbol deserialize(String[] fields) {
        return new CurrencyCodeToSymbol(fields[0], fields[1]);
    }
}