package software.ulpgc.MoneyCalculator.apps.swing;

import software.ulpgc.MoneyCalculator.api.io.currencylayer.*;
import software.ulpgc.MoneyCalculator.api.io.exchangerates.*;
import software.ulpgc.MoneyCalculator.architecture.control.Command;
import software.ulpgc.MoneyCalculator.architecture.control.ConvertCommand;
import software.ulpgc.MoneyCalculator.architecture.control.ExchangeCommand;
import software.ulpgc.MoneyCalculator.architecture.io.*;
import software.ulpgc.MoneyCalculator.architecture.model.Currency;

import javax.swing.*;
import java.io.IOException;
import java.util.List;

public class SwingMain {
    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
        List<Currency> currencies = getCurrencies();
        UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        SwingMainFrame mainFrame = new SwingMainFrame(currencies);
        mainFrame.put("convert", getConvertCommand(mainFrame));
        mainFrame.put("exchange", getExchangeCommand(mainFrame));
        mainFrame.setVisible(true);
        // TODO -> Refactor validators
        // TODO -> Inspect what happens about the precissions of numbers
        // TODO -> Think about to change the API where we get the currencies
    }

    private static Command getExchangeCommand(SwingMainFrame mainFrame) {
        return new ExchangeCommand(mainFrame.getFromCurrency(), mainFrame.getToCurrency(), mainFrame.getMoneyDialog(), mainFrame.getMoneyDisplay());
    }

    private static Command getConvertCommand(SwingMainFrame mainFrame) {
        return new ConvertCommand(mainFrame.getToCurrency(), mainFrame.getMoneyDialog(), mainFrame.getMoneyDisplay(), getExchangeRateLoader());
    }

    private static ExchangeRateLoader getExchangeRateLoader() {
        ExchangeRateReader reader = new CurrencyLayerExchangeRateReader();
        ExchangeRateDeserializer deserializer = new CurrencyLayerExchangeRateDeserializer();
        ExchangeRateAdapter adapter = new CurrencyLayerExchangeRateAdapter();
        return new CurrencyLayerExchangeRateLoader(reader, deserializer, adapter);
    }

    private static List<Currency> getCurrencies() throws IOException {
        SymbolReader reader = new ExchangeRatesSymbolReader();
        SymbolDeserializer deserializer = new ExchangeRatesSymbolDeserializer();
        CurrencyAdapter adapter = new ExchangeRatesCurrencyAdapter();
        return new ExchangeRatesCurrenciesLoader(reader, deserializer, adapter).loadCurrencies();
    }
}
