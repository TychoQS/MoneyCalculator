package software.ulpgc.MoneyCalculator.apps.swing;

import software.ulpgc.MoneyCalculator.api.io.exchangerates.ExchangeRatesCurrencyAdapter;
import software.ulpgc.MoneyCalculator.api.io.exchangerates.ExchangeRatesSymbolDeserializer;
import software.ulpgc.MoneyCalculator.api.io.exchangerates.ExchangeRatesSymbolReader;
import software.ulpgc.MoneyCalculator.architecture.model.Currency;

import java.io.IOException;
import java.util.List;

public class SwingMain {
    public static void main(String[] args) throws IOException {
        List<Currency> currencies = getCurrencies();
        SwingMainFrame mainFrame = new SwingMainFrame(currencies);
        mainFrame.setVisible(true);
        // TODO -> Refactorizar para abrir los recursos perteneciente a la carpeta resources a como hemos visto en clase (Objeto .class)
    }

    private static List<Currency> getCurrencies() throws IOException {
        ExchangeRatesSymbolReader reader = new ExchangeRatesSymbolReader();
        ExchangeRatesSymbolDeserializer deserializer = new ExchangeRatesSymbolDeserializer();
        ExchangeRatesCurrencyAdapter adapter = new ExchangeRatesCurrencyAdapter();
        return adapter.adapt(deserializer.deserialize(reader.read()));
    }
}
