package software.ulpgc.MoneyCalculator.api.io.exchangerates;

import software.ulpgc.MoneyCalculator.architecture.model.Currency;

import java.util.List;

public class ExchangeRatesCurrenciesLoader {
    private final ExchangeRatesSymbolReader reader;
    private final ExchangeRatesSymbolDeserializer deserializer;
    private final ExchangeRatesCurrencyAdapter adapter;

    public ExchangeRatesCurrenciesLoader(ExchangeRatesSymbolReader reader, ExchangeRatesSymbolDeserializer deserializer, ExchangeRatesCurrencyAdapter adapter) {
        this.reader = reader;
        this.deserializer = deserializer;
        this.adapter = adapter;
    }

    public List<Currency> loadCurrencies() {
        return adapter.adapt(deserializer.deserialize(reader.read()));

    }
}
