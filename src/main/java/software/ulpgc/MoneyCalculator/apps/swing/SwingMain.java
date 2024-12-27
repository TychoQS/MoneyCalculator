package software.ulpgc.MoneyCalculator.apps.swing;

import software.ulpgc.MoneyCalculator.api.io.currencylayer.simple.CurrencyLayerExchangeRateAdapter;
import software.ulpgc.MoneyCalculator.api.io.currencylayer.simple.CurrencyLayerExchangeRateDeserializer;
import software.ulpgc.MoneyCalculator.api.io.currencylayer.simple.CurrencyLayerExchangeRateLoader;
import software.ulpgc.MoneyCalculator.api.io.currencylayer.simple.CurrencyLayerExchangeRateReader;
import software.ulpgc.MoneyCalculator.api.io.exchangerates.*;
import software.ulpgc.MoneyCalculator.apps.swing.mainframe.SwingMainFrame;
import software.ulpgc.MoneyCalculator.architecture.control.Command;
import software.ulpgc.MoneyCalculator.architecture.control.ConvertCommand;
import software.ulpgc.MoneyCalculator.architecture.control.ExchangeCommand;
import software.ulpgc.MoneyCalculator.architecture.io.adapters.CurrencyAdapter;
import software.ulpgc.MoneyCalculator.architecture.io.adapters.ExchangeRateAdapter;
import software.ulpgc.MoneyCalculator.architecture.io.readers.ExchangeRateReader;
import software.ulpgc.MoneyCalculator.architecture.io.deserializers.ExchangeRateDeserializer;
import software.ulpgc.MoneyCalculator.architecture.io.loaders.ExchangeRateLoader;
import software.ulpgc.MoneyCalculator.architecture.model.Currency;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class SwingMain {
    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException, FontFormatException {
        List<Currency> currencies = getCurrencies();
        UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        SwingMainFrame mainFrame = new SwingMainFrame(currencies);
        mainFrame.putOnMainFrameCommands("convert", getConvertCommand(mainFrame))
                 .putOnMainFrameCommands("exchange", getExchangeCommand(mainFrame))
                 .setVisible(true);
        // TODO -> Implement time conversion
        // TODO -> Inspect what happens about the precissions of numbers
    }

    private static List<Currency> getCurrencies() throws IOException {
        SymbolReader reader = new ExchangeRatesSymbolReader();
        SymbolDeserializer deserializer = new ExchangeRatesSymbolDeserializer();
        CurrencyAdapter adapter = new ExchangeRatesCurrencyAdapter();
        return new ExchangeRatesCurrenciesLoader(reader, deserializer, adapter).loadCurrencies();
    }

    private static Command getConvertCommand(SwingMainFrame mainFrame) {
        return new ConvertCommand(mainFrame.getToCurrency(), mainFrame.getMoneyDialog(), mainFrame.getMoneyDisplay(), getExchangeRateLoader());
    }

    private static Command getExchangeCommand(SwingMainFrame mainFrame) {
        return new ExchangeCommand(mainFrame.getFromCurrency(), mainFrame.getToCurrency(), mainFrame.getMoneyDialog(), mainFrame.getMoneyDisplay());
    }

    private static ExchangeRateLoader getExchangeRateLoader() {
        ExchangeRateReader reader = new CurrencyLayerExchangeRateReader();
        ExchangeRateDeserializer deserializer = new CurrencyLayerExchangeRateDeserializer();
        ExchangeRateAdapter adapter = new CurrencyLayerExchangeRateAdapter();
        return new CurrencyLayerExchangeRateLoader(reader, deserializer, adapter);
    }
}
