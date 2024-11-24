package software.ulpgc.MoneyCalculator.api.io.currencylayer;

import software.ulpgc.MoneyCalculator.architecture.io.ExchangeRateAdapter;
import software.ulpgc.MoneyCalculator.architecture.io.ExchangeRateLoader;
import software.ulpgc.MoneyCalculator.architecture.model.Currency;
import software.ulpgc.MoneyCalculator.architecture.model.ExchangeRate;

import java.io.IOException;

public class CurrencyLayerExchangeRateLoader implements ExchangeRateLoader {
    private final ExchangeRateReader reader;
    private final ExchangeRateDeserializer deserializer;
    private final ExchangeRateAdapter adapter;

    public CurrencyLayerExchangeRateLoader(ExchangeRateReader reader, ExchangeRateDeserializer deserializer, ExchangeRateAdapter adapter) {
        this.reader = reader;
        this.deserializer = deserializer;
        this.adapter = adapter;
    }

    @Override
    public ExchangeRate load() throws IOException {
        return this.adapter.adapt(deserializer.deserialize(reader.read()));
    }
}
