package software.ulpgc.MoneyCalculator.mock.swing;

import software.ulpgc.MoneyCalculator.api.io.exchangerates.ExchangeRatesCurrencyAdapter;
import software.ulpgc.MoneyCalculator.api.io.exchangerates.ExchangeRatesSymbolDeserializer;
import software.ulpgc.MoneyCalculator.api.io.exchangerates.ExchangeRatesSymbolReader;
import software.ulpgc.MoneyCalculator.architecture.model.Currency;

import java.io.IOException;
import java.util.List;

public class MockMain {
    public static void main(String[] args) throws IOException {
        ExchangeRatesSymbolReader reader = new ExchangeRatesSymbolReader();
        ExchangeRatesSymbolDeserializer deserializer = new ExchangeRatesSymbolDeserializer();
        ExchangeRatesCurrencyAdapter adapter = new ExchangeRatesCurrencyAdapter();
        List<Currency> currencies = adapter.adapt(deserializer.deserialize(reader.read()));
        for (Currency currency : currencies) {
            System.out.println(currency);
        }
    }
}
