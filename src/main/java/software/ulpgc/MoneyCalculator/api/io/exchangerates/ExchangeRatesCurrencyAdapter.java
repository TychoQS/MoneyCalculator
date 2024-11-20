package software.ulpgc.MoneyCalculator.api.io.exchangerates;

import software.ulpgc.MoneyCalculator.api.io.pojos.ExchangeRatesSymbolsGetResponse;
import software.ulpgc.MoneyCalculator.architecture.io.CsvCurrencyCodeToSymbolDeserializer;
import software.ulpgc.MoneyCalculator.architecture.io.CurrencyAdapter;
import software.ulpgc.MoneyCalculator.architecture.io.FileCurrencyCodeToSymbolLoader;
import software.ulpgc.MoneyCalculator.architecture.model.Currency;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExchangeRatesCurrencyAdapter implements CurrencyAdapter {

    private final Map<String, String> codeToSymbols;

    public ExchangeRatesCurrencyAdapter() throws IOException {
        codeToSymbols = new FileCurrencyCodeToSymbolLoader(new File("src/main/resources/currencies_map_iso_to_symbol.csv"), new CsvCurrencyCodeToSymbolDeserializer()).load();
    }

    @Override
    public List<Currency> adapt(Object object) {
        return adapt(((ExchangeRatesSymbolsGetResponse) object));
    }

    private List<Currency> adapt(ExchangeRatesSymbolsGetResponse object) {
        return listOf(object.symbols());
    }

    private List<Currency> listOf(Map<String, String> symbols) {
        List<Currency> currencies = new ArrayList<>();
        for (String code : symbols.keySet()) {
            currencies.add(new Currency(code, symbols.get(code), codeToSymbols.getOrDefault(code, "")));
        }
        return currencies;
    }


}
