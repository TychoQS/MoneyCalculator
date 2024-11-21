package software.ulpgc.MoneyCalculator.apps.swing;

import software.ulpgc.MoneyCalculator.architecture.model.Currency;
import software.ulpgc.MoneyCalculator.architecture.view.CurrenciesDisplay;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SwingExchangePane {

    private final JPanel pane;
    private final CurrenciesDisplay fromCurrency;
    private final CurrenciesDisplay toCurrency;
    private final List<Currency> currencies;

    public SwingExchangePane(List<Currency> currencies) {
        this.currencies = currencies;
        pane = new JPanel(new BorderLayout());
        fromCurrency = new SwingCurrenciesDisplay();
        toCurrency = new SwingCurrenciesDisplay();
        pane.add(BorderLayout.CENTER, comboBoxPane());
        pane.add(BorderLayout.SOUTH, exchangeButton());
        // TODO Probar con BorderLayoutRecursivos
        // TODO Probar con BoxLayout X_AXIS y que cada componente tenga su propio panel.k
    }

    private Component comboBoxPane() {
        JPanel comboBoxPane = new JPanel();
        comboBoxPane.add((Component) fromCurrency);
        comboBoxPane.add((Component) toCurrency);
        return comboBoxPane;
    }

    private Component textField() {
        return new JLabel("Adios");
    }

    private Component exchangeButton() {
        JButton button = new JButton("exchange");
        button.addActionListener(e -> System.out.println("EXCHANGE BUTTON MOCK IMPLEMENTATION"));
        return button;
    }

    public JPanel create() {
        fromCurrency.display(currencies);
        toCurrency.display(currencies);
        return pane;
    }
}
