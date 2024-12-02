package software.ulpgc.MoneyCalculator.apps.swing.moneyconversionframe;

import software.ulpgc.MoneyCalculator.api.io.exchangerates.ExchangeRatesCurrencyAdapter;
import software.ulpgc.MoneyCalculator.api.io.exchangerates.ExchangeRatesSymbolDeserializer;
import software.ulpgc.MoneyCalculator.api.io.exchangerates.ExchangeRatesSymbolReader;
import software.ulpgc.MoneyCalculator.apps.swing.dialogs.SwingCurrenciesDialog;
import software.ulpgc.MoneyCalculator.architecture.model.Currency;
import software.ulpgc.MoneyCalculator.architecture.view.CurrenciesDialog;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class SwingDateMoneyConversionFrame extends JFrame {

    private CurrenciesDialog fromCurrenciesDialog;
    private CurrenciesDialog toCurrenciesDialog;

    public SwingDateMoneyConversionFrame(List<Currency> currencies) throws HeadlessException {
        initFrame();
        this.add(BorderLayout.NORTH, northPane(currencies));
        this.setVisible(true);
    }

    private void initFrame() {
        this.setTitle("Date conversion");
        this.setSize(800, 300);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
    }

    private Component northPane(List<Currency> currencies) {
        JPanel panel = new JPanel();
        fromCurrenciesDialog = new SwingCurrenciesDialog();
        fromCurrenciesDialog.display(currencies);
        toCurrenciesDialog = new SwingCurrenciesDialog();
        toCurrenciesDialog.display(currencies);
        panel.add((Component) fromCurrenciesDialog);
        panel.add((Component) toCurrenciesDialog);
        return panel;
    }

    public static void main(String[] args) throws IOException {
        ExchangeRatesSymbolReader reader = new ExchangeRatesSymbolReader();
        ExchangeRatesSymbolDeserializer deserializer = new ExchangeRatesSymbolDeserializer();
        ExchangeRatesCurrencyAdapter adapter = new ExchangeRatesCurrencyAdapter();
        List<software.ulpgc.MoneyCalculator.architecture.model.Currency> currencies = adapter.adapt(deserializer.deserialize(reader.read()));
        SwingDateMoneyConversionFrame frame = new SwingDateMoneyConversionFrame(currencies);
    }

    public CurrenciesDialog getFromCurrenciesDialog() {
        return fromCurrenciesDialog;
    }

    public CurrenciesDialog getToCurrenciesDialog() {
        return toCurrenciesDialog;
    }
}
