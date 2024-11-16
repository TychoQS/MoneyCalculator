package software.ulpgc.MoneyCalculator;

import software.ulpgc.MoneyCalculator.api.io.exchangerates.ExchangeRatesCurrencyLoader;
import software.ulpgc.MoneyCalculator.architecture.io.FileCurrencyCodeToSymbolLoader;
import software.ulpgc.MoneyCalculator.architecture.model.CsvCurrencyCodeToSymbolDeserializer;
import software.ulpgc.MoneyCalculator.architecture.model.Currency;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Currency> currencies = new ExchangeRatesCurrencyLoader(new FileCurrencyCodeToSymbolLoader(getIsoCodeToSymbolFile(), getCurrencyCodeToSymbolDeserializer())).load();
        for (Currency currency : currencies) {
            System.out.println(currency);
        }
        System.out.println("Cantidad de Currencies: " + currencies.size());
    }

    private static CsvCurrencyCodeToSymbolDeserializer getCurrencyCodeToSymbolDeserializer() {
        return new CsvCurrencyCodeToSymbolDeserializer();
    }

    private static File getIsoCodeToSymbolFile() {
        return new File("src/main/resources/currencies_map_iso_to_symbol.csv");
    }
}
