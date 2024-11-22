package software.ulpgc.MoneyCalculator.apps.swing;

import software.ulpgc.MoneyCalculator.api.io.exchangerates.*;
import software.ulpgc.MoneyCalculator.architecture.io.CurrencyAdapter;
import software.ulpgc.MoneyCalculator.architecture.model.Currency;

import javax.swing.*;
import java.io.IOException;
import java.util.List;

public class SwingMain {
    public static void main(String[] args) throws IOException {
        List<Currency> currencies = getCurrencies();
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
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
