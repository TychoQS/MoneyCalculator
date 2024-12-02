package software.ulpgc.MoneyCalculator.apps.swing.moneyconversionframe;

import software.ulpgc.MoneyCalculator.api.io.exchangerates.ExchangeRatesCurrencyAdapter;
import software.ulpgc.MoneyCalculator.api.io.exchangerates.ExchangeRatesSymbolDeserializer;
import software.ulpgc.MoneyCalculator.api.io.exchangerates.ExchangeRatesSymbolReader;
import software.ulpgc.MoneyCalculator.apps.swing.displays.SwingMoneyDisplay;
import software.ulpgc.MoneyCalculator.apps.swing.dialogs.SwingCurrenciesDialog;
import software.ulpgc.MoneyCalculator.apps.swing.dialogs.SwingErrorDialog;
import software.ulpgc.MoneyCalculator.apps.swing.dialogs.SwingMoneyDialog;
import software.ulpgc.MoneyCalculator.architecture.control.Command;
import software.ulpgc.MoneyCalculator.architecture.model.Currency;
import software.ulpgc.MoneyCalculator.architecture.view.CurrenciesDialog;
import software.ulpgc.MoneyCalculator.architecture.view.MoneyDialog;
import software.ulpgc.MoneyCalculator.architecture.view.MoneyDisplay;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SwingDateMoneyConversionFrame extends JFrame {

    private final Map<String, Command> commands;
    private CurrenciesDialog fromCurrenciesDialog;
    private CurrenciesDialog toCurrenciesDialog;
    private MoneyDialog moneyDialog;
    private MoneyDisplay moneyDisplay;

    public SwingDateMoneyConversionFrame(List<Currency> currencies) throws HeadlessException {
        this.commands = new HashMap<>();
        initFrame();
        this.add(BorderLayout.NORTH, northPane(currencies));
        this.add(BorderLayout.CENTER, centerPane());
    }

    private Component centerPane() {
        JPanel centerPane = new JPanel();
        moneyDialog = new SwingMoneyDialog(this.fromCurrenciesDialog);
        moneyDisplay = new SwingMoneyDisplay();
        centerPane.add((Component) moneyDialog);
        centerPane.add(convertButton());
        centerPane.add((Component) moneyDisplay);
        return centerPane;

    }

    public Command put(String key, Command value) {
        return commands.put(key, value);
    }

    private void initFrame() {
        this.setTitle("Date conversion");
        this.setSize(800, 300);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
    }

    private Component northPane(List<Currency> currencies) {
        JPanel northPane = new JPanel();
        fromCurrenciesDialog = new SwingCurrenciesDialog();
        fromCurrenciesDialog.display(currencies);
        toCurrenciesDialog = new SwingCurrenciesDialog();
        toCurrenciesDialog.display(currencies);
        northPane.add((Component) fromCurrenciesDialog);
        northPane.add((Component) toCurrenciesDialog);
        return northPane;
    }

    private Component convertButton() {
        JButton button = new JButton("Convert");
        button.addActionListener(e -> new SwingErrorDialog("MOCK", "MOCK IMPLEMENTATION")); // TODO -> Implement feature
        return button;
    }

    public static void main(String[] args) throws IOException {
        ExchangeRatesSymbolReader reader = new ExchangeRatesSymbolReader();
        ExchangeRatesSymbolDeserializer deserializer = new ExchangeRatesSymbolDeserializer();
        ExchangeRatesCurrencyAdapter adapter = new ExchangeRatesCurrencyAdapter();
        List<software.ulpgc.MoneyCalculator.architecture.model.Currency> currencies = adapter.adapt(deserializer.deserialize(reader.read()));
        HashMap<String, Command> map = new HashMap<>();
        SwingDateMoneyConversionFrame frame = new SwingDateMoneyConversionFrame(currencies);
    }

    public CurrenciesDialog getFromCurrenciesDialog() {
        return fromCurrenciesDialog;
    }

    public CurrenciesDialog getToCurrenciesDialog() {
        return toCurrenciesDialog;
    }
}
