package software.ulpgc.MoneyCalculator.apps.swing;

import com.sun.tools.javac.Main;
import software.ulpgc.MoneyCalculator.api.io.exchangerates.*;
import software.ulpgc.MoneyCalculator.architecture.io.CurrencyAdapter;
import software.ulpgc.MoneyCalculator.architecture.model.Currency;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class SwingMain {
    public static void main(String[] args) throws IOException {
        List<Currency> currencies = getCurrencies();
        SwingMainFrame mainFrame = new SwingMainFrame(currencies);
        mainFrame.setVisible(true);
    }

    private static List<Currency> getCurrencies() throws IOException {
        SymbolReader reader = new ExchangeRatesSymbolReader();
        SymbolDeserializer deserializer = new ExchangeRatesSymbolDeserializer();
        CurrencyAdapter adapter = new ExchangeRatesCurrencyAdapter();
        return new ExchangeRatesCurrenciesLoader(reader, deserializer, adapter).loadCurrencies();
    }
}
