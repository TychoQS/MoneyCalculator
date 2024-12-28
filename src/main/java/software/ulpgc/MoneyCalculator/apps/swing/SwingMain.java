package software.ulpgc.MoneyCalculator.apps.swing;

import software.ulpgc.MoneyCalculator.api.io.currencylayer.date.CurrencyLayerDateExchangeRateAdapter;
import software.ulpgc.MoneyCalculator.api.io.currencylayer.date.CurrencyLayerDateConversionDeserializer;
import software.ulpgc.MoneyCalculator.api.io.currencylayer.date.CurrencyLayerDateExchangeRateLoader;
import software.ulpgc.MoneyCalculator.api.io.currencylayer.date.CurrencyLayerDateConversionReader;
import software.ulpgc.MoneyCalculator.api.io.currencylayer.basic.CurrencyLayerExchangeRateAdapter;
import software.ulpgc.MoneyCalculator.api.io.currencylayer.basic.CurrencyLayerExchangeRateDeserializer;
import software.ulpgc.MoneyCalculator.api.io.currencylayer.basic.CurrencyLayerExchangeRateLoader;
import software.ulpgc.MoneyCalculator.api.io.currencylayer.basic.CurrencyLayerExchangeRateReader;
import software.ulpgc.MoneyCalculator.api.io.exchangerates.*;
import software.ulpgc.MoneyCalculator.apps.swing.date.conversion.frame.SwingDateMoneyConversionFrame;
import software.ulpgc.MoneyCalculator.apps.swing.mainframe.SwingMainFrame;
import software.ulpgc.MoneyCalculator.architecture.control.commands.Command;
import software.ulpgc.MoneyCalculator.architecture.control.commands.ConvertCommand;
import software.ulpgc.MoneyCalculator.architecture.control.commands.ConvertFromDateCommand;
import software.ulpgc.MoneyCalculator.architecture.control.commands.ExchangeCommand;
import software.ulpgc.MoneyCalculator.architecture.io.adapters.CurrencyAdapter;
import software.ulpgc.MoneyCalculator.architecture.io.adapters.ExchangeRateAdapter;
import software.ulpgc.MoneyCalculator.architecture.io.loaders.DateExchangeRateLoader;
import software.ulpgc.MoneyCalculator.architecture.io.readers.ExchangeRateReader;
import software.ulpgc.MoneyCalculator.architecture.io.deserializers.ExchangeRateDeserializer;
import software.ulpgc.MoneyCalculator.architecture.io.loaders.ExchangeRateLoader;
import software.ulpgc.MoneyCalculator.architecture.model.Currency;

import javax.swing.*;
import java.io.IOException;
import java.util.List;

public class SwingMain {
    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
        List<Currency> currencies = getCurrencies();
        UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        SwingMainFrame mainFrame = new SwingMainFrame(currencies);
        mainFrame.putOnMainFrameCommands("convert", getConvertCommand(mainFrame))
                 .putOnMainFrameCommands("exchange", getExchangeCommand(mainFrame))
                 .putOnDateConversionFrameCommands("convert", getDateConvertCommand(mainFrame.getDateMoneyConversionFrame()))
                 .setVisible(true);
        // TODO -> Reimplement SwapConverter with method in interfaces instead.
        // TODO -> Inspect what happens about the precissions of numbers
        // TODO -> Review Exceptions
        // TODO -> Review Appearance (GUI)
        // TODO -> Remove todos and mains
        // TODO -> Check "Suciedad"
    }

    private static List<Currency> getCurrencies() throws IOException {
        SymbolReader reader = new ExchangeRatesSymbolReader();
        SymbolDeserializer deserializer = new ExchangeRatesSymbolDeserializer();
        CurrencyAdapter adapter = new ExchangeRatesCurrencyAdapter();
        return new ExchangeRatesCurrenciesLoader(reader, deserializer, adapter).loadCurrencies();
    }

    private static Command getConvertCommand(SwingMainFrame mainFrame) {
        return new ConvertCommand(mainFrame.getToCurrency(), mainFrame.getMoneyDialog(), mainFrame.getMoneyDisplay(), getBasicExchangeRateLoader());
    }

    private static Command getDateConvertCommand(SwingDateMoneyConversionFrame frame) {
        return new ConvertFromDateCommand(frame.getToCurrenciesDialog(), frame.getDateDialog(), frame.getMoneyDisplay(), frame.getMoneyDialog(), getDateExchangeRateLoader());
    }

    private static DateExchangeRateLoader getDateExchangeRateLoader() {
        CurrencyLayerDateConversionReader reader = new CurrencyLayerDateConversionReader();
        CurrencyLayerDateConversionDeserializer deserializer = new CurrencyLayerDateConversionDeserializer();
        CurrencyLayerDateExchangeRateAdapter adapter = new CurrencyLayerDateExchangeRateAdapter();
        return new CurrencyLayerDateExchangeRateLoader(reader, deserializer, adapter);
    }

    private static Command getExchangeCommand(SwingMainFrame mainFrame) {
        return new ExchangeCommand(mainFrame.getFromCurrency(), mainFrame.getToCurrency(), mainFrame.getMoneyDialog(), mainFrame.getMoneyDisplay());
    }

    private static ExchangeRateLoader getBasicExchangeRateLoader() {
        ExchangeRateReader reader = new CurrencyLayerExchangeRateReader();
        ExchangeRateDeserializer deserializer = new CurrencyLayerExchangeRateDeserializer();
        ExchangeRateAdapter adapter = new CurrencyLayerExchangeRateAdapter();
        return new CurrencyLayerExchangeRateLoader(reader, deserializer, adapter);
    }
}
